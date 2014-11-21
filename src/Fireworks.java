import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.pushingpixels.trident.Timeline;
import org.pushingpixels.trident.Timeline.RepeatBehavior;
import org.pushingpixels.trident.TimelineScenario;
import org.pushingpixels.trident.callback.TimelineScenarioCallback;
import org.pushingpixels.trident.ease.Spline;
import org.pushingpixels.trident.swing.SwingRepaintTimeline;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public final class Fireworks extends JFrame {
	private Set<VolleyExplosion> volleys;

	private Map<VolleyExplosion, TimelineScenario> volleyScenarios;

	private JPanel mainPanel;

        private final String iconApplicaiton="svg/AfricaIcone.png";
    /**
     * @return the mainPanel
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }
    
     /**
     * 
     * @param imagePath : the path to the image
     * @return Image: ImageIcon object
     */
    public Image buildImage(String imagePath){
        ImageIcon imgIco=new ImageIcon();
        Image img=null;
        try {
            imgIco= new ImageIcon(imagePath);
            img=imgIco.getImage();
        } catch (Exception e) {
            System.err.println("Error in Building IconImage. Please very the path");
        }
        
        return img;
    }

    /**
     * @param mainPanel the mainPanel to set
     */
    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

	public class SingleExplosion {
		float x;

		float y;

		float radius;

		float opacity;

		Color color;

		public SingleExplosion(Color color, float x, float y, float radius) {
			this.color = color;
			this.x = x;
			this.y = y;
			this.radius = radius;
			this.opacity = 1.0f;
		}

		public void setX(float x) {
			this.x = x;
		}

		public void setY(float y) {
			this.y = y;
		}

		public void setRadius(float radius) {
			this.radius = radius;
		}

		public void setOpacity(float opacity) {
			this.opacity = opacity;
		}

		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setComposite(AlphaComposite.SrcOver.derive(this.opacity));
			g2d.setColor(this.color);
			g2d.fill(new Ellipse2D.Float(this.x - this.radius, this.y
					- this.radius, 2 * radius, 2 * radius));
			g2d.dispose();
		}
	}

	public class VolleyExplosion {
		private int x;

		private int y;

		private Color color;

		private Set<SingleExplosion> circles;

		public VolleyExplosion(int x, int y, Color color) {
			this.x = x;
			this.y = y;
			this.color = color;
			this.circles = new HashSet<SingleExplosion>();
		}

		public TimelineScenario getExplosionScenario() {
			TimelineScenario scenario = new TimelineScenario.Parallel();

			Random randomizer = new Random();
			int duration = 1000 + randomizer.nextInt(1000);
			for (int i = 0; i < 18; i++) {
				float dist = (float) (50 + 10 * Math.random());
				float radius = (float) (2 + 2 * Math.random());
				for (float delta = 0.6f; delta <= 1.0f; delta += 0.2f) {
					float circleRadius = radius * delta;

					double degrees = 20.0 * (i + Math.random());
					float radians = (float) (2.0 * Math.PI * degrees / 360.0);

					float initDist = delta * dist / 10.0f;
					float finalDist = delta * dist;
					float initX = (float) (this.x + initDist
							* Math.cos(radians));
					float initY = (float) (this.y + initDist
							* Math.sin(radians));
					float finalX = (float) (this.x + finalDist
							* Math.cos(radians));
					float finalY = (float) (this.y + finalDist
							* Math.sin(radians));

					SingleExplosion circle = new SingleExplosion(this.color,
							initX, initY, circleRadius);
					Timeline timeline = new Timeline(circle);
					timeline.addPropertyToInterpolate("x", initX, finalX);
					timeline.addPropertyToInterpolate("y", initY, finalY);
					timeline.addPropertyToInterpolate("opacity", 1.0f, 0.0f);
					timeline.setDuration(duration - 200
							+ randomizer.nextInt(400));
					timeline.setEase(new Spline(0.4f));

					synchronized (this.circles) {
						circles.add(circle);
					}
					scenario.addScenarioActor(timeline);
				}
			}

			return scenario;
		}

		public void paint(Graphics g) {
			synchronized (this.circles) {
				for (SingleExplosion circle : this.circles) {
					circle.paint(g);
				}
			}
		}
	}

	public Fireworks() {
		super("Know Africa Congratulations");
                
//                this.setIconIma;
                
                this.setIconImage(buildImage(iconApplicaiton));
                
		this.mainPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				synchronized (volleys) {
					for (VolleyExplosion exp : volleys)
						exp.paint(g);
				}
			}
		};
		this.mainPanel.setBackground(Color.black);
		this.mainPanel.setPreferredSize(new Dimension(480, 320));

		Timeline repaint = new SwingRepaintTimeline(this);
		repaint.playLoop(RepeatBehavior.LOOP);

		this.volleys = new HashSet<VolleyExplosion>();
		this.volleyScenarios = new HashMap<VolleyExplosion, TimelineScenario>();

		this.mainPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				synchronized (volleys) {
					for (TimelineScenario scenario : volleyScenarios.values())
						scenario.suspend();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				synchronized (volleys) {
					for (TimelineScenario scenario : volleyScenarios.values())
						scenario.resume();
				}
			}
		});

		mainPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				if ((getMainPanel().getWidth() == 0) || (getMainPanel().getHeight() == 0))
					return;
				new Thread() {
					@Override
					public void run() {
						while (true) {
							addExplosions(5);
						}
					}
				}.start();
			}
		});
                
                this.addWindowFocusListener(new WindowAdapter() {
                    
                    @Override
                    public void windowClosing(WindowEvent e)
                    {
                        MainWindow newmain=new MainWindow();
                        newmain.setVisible(true);
                        e.getWindow().dispose();
                    }
                
                });

		this.add(mainPanel);
                //this.add(new JButton("TEST"),)
                playSound();
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
	}
        
        

	private void addExplosions(int count) {
		final CountDownLatch latch = new CountDownLatch(count);

		Random randomizer = new Random();
		for (int i = 0; i < count; i++) {
			int r = randomizer.nextInt(255);
			int g = 100 + randomizer.nextInt(155);
			int b = 50 + randomizer.nextInt(205);
			Color color = new Color(r, g, b);

			int x = 60 + randomizer.nextInt(getMainPanel().getWidth() - 120);
			int y = 60 + randomizer.nextInt(getMainPanel().getHeight() - 120);
			final VolleyExplosion exp = new VolleyExplosion(x, y, color);
			synchronized (volleys) {
				volleys.add(exp);
				TimelineScenario scenario = exp.getExplosionScenario();
				scenario.addCallback(new TimelineScenarioCallback() {
					@Override
					public void onTimelineScenarioDone() {
						synchronized (volleys) {
							volleys.remove(exp);
							volleyScenarios.remove(exp);
							latch.countDown();
						}
					}
				});
				volleyScenarios.put(exp, scenario);
				scenario.play();
			}
		}

		try {
			latch.await();
		} catch (Exception exc) {
		}
	}
        
        public static void playSound(){
            try {
//                Clip clip=AudioSystem.getClip();
//                AudioInputStream soundStream= AudioSystem.getAudioInputStream(new FileInputStream("svg/fireworksound.mp3"));
                File file=new File("svg/fireworksound.au");
                System.out.println(" File = "+file.getName());
                InputStream sfile=new FileInputStream(file);
                AudioStream audiostream=new AudioStream(sfile);
                
                AudioPlayer.player.start(audiostream);
//                clip.open(soundStream);
            } catch (Exception ex) {
                Logger.getLogger(Fireworks.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Fireworks().setVisible(true);
                                playSound();
                                
			}
		});
	}

}