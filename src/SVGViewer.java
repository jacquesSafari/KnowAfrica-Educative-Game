
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.script.Window;
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.svg.GVTTreeBuilderAdapter;
import org.apache.batik.swing.svg.GVTTreeBuilderEvent;
import org.apache.batik.swing.svg.SVGDocumentLoaderAdapter;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;
import org.apache.batik.swing.svg.SVGLoadEventDispatcherAdapter;
import org.apache.batik.swing.svg.SVGLoadEventDispatcherEvent;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Safari
 */
public final class SVGViewer {
    
    //define the canvas
    protected JSVGCanvas svgcanvas = new JSVGCanvas();
    //the panel on which to print
    JPanel canvaspanel;
    //the SVG file to print
    String svgfilename;
    Document document;
    Element element;
    //to manage the attemps
    int attempts=0;
    //to manage successfull answers
    int successAnswers=0;
    //to control the click and print the country clicked on 
    private JLabel yourSelection;
    private JLabel yourSelection2;
    private JLabel photoLabel;
    private JLabel heroName;
    private JLabel successLbl;
    private JLabel successShot;
    private JLabel congratLbl;
    
    Window window;

    Answer myAnswer;
    JFrame SVGFrame;
    private JTextArea questionArea;
    private JLabel lb1_1;
    private JLabel lbl1_2;
    private JLabel lbl1_3;
    private JLabel lbl1_4;
    private JLabel lbl1_5;
    JLabel lbl5;
    
    private JTextArea questionArea2;
    private JTextArea heroDetails;
    
    private JPanel congratPanel;
    
    private JFrame frameLevel2;
    private JFrame frameLevel3;
    private JFrame frameCongrat;
    private JFrame frameHelp;
    
    //timers
    private JLabel lbltimer_1;
    private int time;
    private Timer timer;
    private boolean fail=false;
    private boolean lastQ=false;
  
   private static CurrentObjects currentObjects;
    
    public SVGViewer() {
        currentObjects=new CurrentObjects();
    }

    public SVGViewer(JPanel canvaspanel, String svgfile,final JFrame frame) {
//        this.canvaspanel.removeAll();
        
        this.canvaspanel = canvaspanel;
        this.svgfilename = svgfile;
        
        this.canvaspanel.setLayout(new BorderLayout());
        this.SVGFrame=frame;
        //sets the svg image loaded to be dynamic
        svgcanvas.setDocumentState(JSVGCanvas.ALWAYS_DYNAMIC);
        //bind event listeners
        svgcanvas.addSVGLoadEventDispatcherListener(new SVGLoadEventDispatcherAdapter(){

            @Override
            public void svgLoadEventDispatchStarted(SVGLoadEventDispatcherEvent e){
              document= svgcanvas.getSVGDocument();
              window = svgcanvas.getUpdateManager().getScriptingEnvironment().createWindow();
                System.out.println("Load Event Dispatch Started"+document);
                
                addLoadListerner();
                addTreeBuilderListener();
                addEventListeners();
       
         
            }
            
        });
//        document=this.createDocument();
       
        
         
         svgcanvas.setURI(new File(svgfilename).toURI().toString());
         System.out.println("IsFile ? "+(new File(svgfilename)).isFile());
         
//         frame.addWindowListener(new WindowAdapter() {
//
//            @Override
//            public void windowActivated(WindowEvent e) {
//                svgcanvas.setURI(new File(svgfilename).toURI().toString());
//                    System.out.println("Window opened"); //To change body of generated methods, choose Tools | Templates.
//            }
//                
//                public void windowOpened(WindowEvent e) {
//                    // The canvas is ready to load the base document
//                    // now, from the AWT thread.
//                    svgcanvas.setURI(new File(svgfilename).toURI().toString());
//                    System.out.println("Window opened");
//                }
//            });
         this.canvaspanel.add(svgcanvas,BorderLayout.CENTER);
         
        frame.pack();
         
//        System.out.println(" Elments "+document.getElementById("cd").toString());
//        
//        ((EventTarget)document.getElementById("cd")).addEventListener("click", new OnClickAction(), false);
    }

    
     public void view() {
//         this.canvaspanel.removeAll();
//         this.canvaspanel.updateUI();
         this.canvaspanel.add(svgcanvas,BorderLayout.CENTER);
         try{
            svgcanvas.setURI(getSvgFileURI());
//            svgcanvas.setURI(document.getDocumentURI());

        }catch(Exception e){
            System.err.println("An error occured, Please check the URI");
            e.printStackTrace();
        }
     
        
    }
   /**
    * To add event listeners to the svg image
    */ 
   public void addEventListeners(){
       //Gets all elements from the loaded document
//       Element elem;
//        elem = document.getElementById("za");
       EventTarget et=(EventTarget)document;
       
       et.addEventListener("click", new OnClickAction(), false);
       et.addEventListener("mouseover", new OnMouseOverAction(), false);
       et.addEventListener("mouseout", new OnMouseMoveAction(), false);
       
   }  
     
   public Document createDocument(){
       Document doc=null;
       try {
        String parser = XMLResourceDescriptor.getXMLParserClassName();
        SAXSVGDocumentFactory factory = new SAXSVGDocumentFactory(parser); 
        doc = factory.createDocument(this.getSvgFileURI());
        } catch (Exception ex) {
            System.err.println("An Error occured when creating the document");
            ex.printStackTrace();
        }
       return doc;
   }
    

    
    public File getSvgFile(){
        try {
            return new File(getSvgfilename());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public String getSvgFileURI(){
        try {
            return getSvgFile().toURI().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
   //Pass the svgfilename to view to the canvas
    public void setCanvasUri(){
        try{
            svgcanvas.setURI(getSvgFileURI());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
   //Adding SVGCanvas events listners
    
    public void addLoadListerner(){
        svgcanvas.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter() {

            @Override
            public void documentLoadingStarted(SVGDocumentLoaderEvent e) {
                System.out.println("Document Loading Started");
            }
            

            @Override
            public void documentLoadingCompleted(SVGDocumentLoaderEvent e) {
                System.out.println("Document Loading completed");
            }

            @Override
            public void documentLoadingCancelled(SVGDocumentLoaderEvent e) {
                System.err.println("Loading have been Cancelled");
            }

            @Override
            public void documentLoadingFailed(SVGDocumentLoaderEvent e) {
                System.err.println("The system failed to Load the document");
            }
            
            
                
        });
        
        
    }
    
    //Tree builder listener
    public void addTreeBuilderListener(){
        svgcanvas.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter() {

            @Override
            public void gvtBuildStarted(GVTTreeBuilderEvent e) {
                System.out.println("Tree Building Started");
            }

            @Override
            public void gvtBuildCompleted(GVTTreeBuilderEvent e) {
                System.out.println("Tree Building completed");
            }

            @Override
            public void gvtBuildFailed(GVTTreeBuilderEvent e) {
                System.err.println("Building Failed...");
            }
  
        });
    }
    
    //

    
    public JPanel getCanvaspanel() {
        return canvaspanel;
    }

    public JSVGCanvas getSvgcanvas() {
        return svgcanvas;
    }

    public String getSvgfilename() {
        return svgfilename;
    }

    public void setCanvaspanel(JPanel canvaspanel) {
        this.canvaspanel = canvaspanel;
    }

    public void setSvgcanvas(JSVGCanvas svgcanvas) {
        this.svgcanvas = svgcanvas;
    }

    public void setSvgfilename(String svgfilename) {
        this.svgfilename = svgfilename;
    }

    /**
     * @return the lb1_1
     */
    public JLabel getLb1_1() {
        return lb1_1;
    }

    /**
     * @param lb1_1 the lb1_1 to set
     */
    public void setLb1_1(JLabel lb1_1) {
        this.lb1_1 = lb1_1;
    }

    /**
     * @return the lbl1_2
     */
    public JLabel getLbl1_2() {
        return lbl1_2;
    }

    /**
     * @param lbl1_2 the lbl1_2 to set
     */
    public void setLbl1_2(JLabel lbl1_2) {
        this.lbl1_2 = lbl1_2;
    }

    /**
     * @return the lbl1_3
     */
    public JLabel getLbl1_3() {
        return lbl1_3;
    }

    /**
     * @param lbl1_3 the lbl1_3 to set
     */
    public void setLbl1_3(JLabel lbl1_3) {
        this.lbl1_3 = lbl1_3;
    }

    /**
     * @return the lbl1_4
     */
    public JLabel getLbl1_4() {
        return lbl1_4;
    }

    /**
     * @param lbl1_4 the lbl1_4 to set
     */
    public void setLbl1_4(JLabel lbl1_4) {
        this.lbl1_4 = lbl1_4;
    }

    /**
     * @return the questionArea
     */
    public JTextArea getQuestionArea() {
        return questionArea;
    }

    /**
     * @param questionArea the questionArea to set
     */
    public void setQuestionArea(JTextArea questionArea) {
        this.questionArea = questionArea;
    }

    /**
     * @return the lbl1_5
     */
    public JLabel getLbl1_5() {
        return lbl1_5;
    }

    /**
     * @param lbl1_5 the lbl1_5 to set
     */
    public void setLbl1_5(JLabel lbl1_5) {
        this.lbl1_5 = lbl1_5;
    }

    /**
     * @return the yourSelection
     */
    public JLabel getYourSelection() {
        return yourSelection;
    }

    /**
     * @param yourSelection the yourSelection to set
     */
    public void setYourSelection(JLabel yourSelection) {
        this.yourSelection = yourSelection;
    }

    /**
     * @return the frameLevel2
     */
    public JFrame getFrameLevel2() {
        return frameLevel2;
    }

    /**
     * @param frameLevel2 the frameLevel2 to set
     */
    public void setFrameLevel2(JFrame frameLevel2) {
        this.frameLevel2 = frameLevel2;
    }

    /**
     * @return the frameLevel3
     */
    public JFrame getFrameLevel3() {
        return frameLevel3;
    }

    /**
     * @param frameLevel3 the frameLevel3 to set
     */
    public void setFrameLevel3(JFrame frameLevel3) {
        this.frameLevel3 = frameLevel3;
    }

    /**
     * @return the yourSelection2
     */
    public JLabel getYourSelection2() {
        return yourSelection2;
    }

    /**
     * @param yourSelection2 the yourSelection2 to set
     */
    public void setYourSelection2(JLabel yourSelection2) {
        this.yourSelection2 = yourSelection2;
    }

    /**
     * @return the questionArea2
     */
    public JTextArea getQuestionArea2() {
        return questionArea2;
    }

    /**
     * @param questionArea2 the questionArea2 to set
     */
    public void setQuestionArea2(JTextArea questionArea2) {
        this.questionArea2 = questionArea2;
    }

    /**
     * @return the photoLabel
     */
    public JLabel getPhotoLabel() {
        return photoLabel;
    }

    /**
     * @param photoLabel the photoLabel to set
     */
    public void setPhotoLabel(JLabel photoLabel) {
        this.photoLabel = photoLabel;
    }

    /**
     * @return the heroDetails
     */
    public JTextArea getHeroDetails() {
        return heroDetails;
    }

    /**
     * @param heroDetails the heroDetails to set
     */
    public void setHeroDetails(JTextArea heroDetails) {
        this.heroDetails = heroDetails;
    }

    /**
     * @return the heroName
     */
    public JLabel getHeroName() {
        return heroName;
    }

    /**
     * @param heroName the heroName to set
     */
    public void setHeroName(JLabel heroName) {
        this.heroName = heroName;
    }

    /**
     * @return the successLbl
     */
    public JLabel getSuccessLbl() {
        return successLbl;
    }

    /**
     * @param successLbl the successLbl to set
     */
    public void setSuccessLbl(JLabel successLbl) {
        this.successLbl = successLbl;
    }

    /**
     * @return the successShot
     */
    public JLabel getSuccessShot() {
        return successShot;
    }

    /**
     * @param successShot the successShot to set
     */
    public void setSuccessShot(JLabel successShot) {
        this.successShot = successShot;
    }

    /**
     * @return the frameCongrat
     */
    public JFrame getFrameCongrat() {
        return frameCongrat;
    }

    /**
     * @param frameCongrat the frameCongrat to set
     */
    public void setFrameCongrat(JFrame frameCongrat) {
        this.frameCongrat = frameCongrat;
    }

    /**
     * @return the frameHelp
     */
    public JFrame getFrameHelp() {
        return frameHelp;
    }

    /**
     * @param frameHelp the frameHelp to set
     */
    public void setFrameHelp(JFrame frameHelp) {
        this.frameHelp = frameHelp;
    }

    /**
     * @return the congratLbl
     */
    public JLabel getCongratLbl() {
        return congratLbl;
    }

    /**
     * @param congratLbl the congratLbl to set
     */
    public void setCongratLbl(JLabel congratLbl) {
        this.congratLbl = congratLbl;
    }

    /**
     * @return the congratPanel
     */
    public JPanel getCongratPanel() {
        return congratPanel;
    }

    /**
     * @param congratPanel the congratPanel to set
     */
    public void setCongratPanel(JPanel congratPanel) {
        this.congratPanel = congratPanel;
    }

    /**
     * @return the lbltimer_1
     */
    public JLabel getLbltimer_1() {
        return lbltimer_1;
    }

    /**
     * @param lbltimer_1 the lbltimer_1 to set
     */
    public void setLbltimer_1(JLabel lbltimer_1) {
        this.lbltimer_1 = lbltimer_1;
    }

    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * @return the timer
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     * @param timer the timer to set
     */
    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    private class OnMouseOverAction implements EventListener {

        @Override
        public void handleEvent(Event evt) {
           Element element=(Element)evt.getTarget();
           element.setAttribute("fill", "#F9F9B9");
           
//           canvaspanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           System.err.println("test  : "+((Element)evt.getTarget()).getAttribute("fill"));
        }
    }

    private  class OnMouseMoveAction implements EventListener {

        @Override
        public void handleEvent(Event evt) {
          Element element=(Element)evt.getTarget();
           element.setAttribute("fill", "#B9B9B9");
           System.err.println("test  : "+((Element)evt.getTarget()).getAttribute("fill"));
//            canvaspanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    private class OnClickAction implements EventListener {

     

        @Override
        public void handleEvent(Event evt) {
            String id="";
            Country countryClicked;
            System.err.println("Document was clicked"+evt.getTarget().toString()); 
//            window.alert("Tested!"+((Element)evt.getTarget()).getAttribute("id"));
        System.err.println("test  : "+((Element)evt.getTarget()).getAttribute("id"));
        System.err.println("Child nodes # : "+((Element)((Element)evt.getTarget()).getParentNode()).getAttribute("id"));
//        Element el=(Element)evt.getTarget();
//     
//        Node node=el.cloneNode(false);
//        node.getAttributes().getNamedItem("id");
        
        //Matching the selected country to the correct id
//        id=((Element)evt.getTarget()).getAttribute("id");
        Node node=(Node)evt.getTarget();
        id=((Element)node).getAttribute("id");
          try{
//              countryClicked=MainWindow.dataHashMap.get(id);
//              if(!countryClicked.equals(null))
//                   window.alert("Country Clicked "+countryClicked.getName()+ " HERO "+countryClicked.getHero().getFullname()+" Deceased on "+countryClicked.getHero().getDeceased());
              if(!MainWindow.dataHashMap.containsKey(id))
              for(int i=0;i<3;i++){
                  id=((Element)node.getParentNode()).getAttribute("id");
                  if(!MainWindow.dataHashMap.containsKey(id))
                      node=node.getParentNode();
                  else
                      break;
              }
              
//              if(id.startsWith("path"))
//                  id=((Element)node.getParentNode()).getAttribute("id");
//              else if(!MainWindow.dataHashMap.containsKey(id)){
//                  id=((Element)node.getParentNode().getParentNode()).getAttribute("id");
//                  System.out.println("id "+ id);
//              }
              countryClicked=MainWindow.dataHashMap.get(id);
//              window.alert("Country Clicked "+countryClicked.getName()+ " HERO "+countryClicked.getHero().getFullname()+" Deceased on "+countryClicked.getHero().getDeceased());
              //Check the answer if it's true
              if(MainWindow.currentLevel==1)
              yourSelection.setText("Your Selection : "+countryClicked.getName());
              else
                getYourSelection2().setText("Your Selection : "+countryClicked.getName());
              
              myAnswer=new Answer();
              if(myAnswer.checkAnswer(id, MainWindow.currentQuestion)){
//                  System.out.println("ID OF QUESTION "+id + " CURRENT QUESTION "+MainWindow.currentQuestion.getRandomCountryID());
//                      window.alert(" Got It");
//                      lb1_1.setText("Got It");
//                      lb1_1.setBackground(Color.green);
                  successAnswers++;
                  attempts=0;
                  //RESET THE TIMER HERE
//                  setTime(MainWindow.time);
                  stopTimer();
//                  startTimer();
                  initTimer();
                  fail=false;
                   if(MainWindow.currentLevel==1){
                    switch(Question.questionNumber){
                        case 1:
//                            lb1_1.setText("Answer 1");
//                            decorateAnswerLabel(lb1_1, true);
//                            MainWindow.nextQuestion(1);
//                            attempts=0;
//                            questionArea.setText(MainWindow.currentQuestion.generateRandomQuestion());
                            nextQUpdateElments(lb1_1,"Answer 1", 1,1,true);
                            currentObjects=new CurrentObjects(lb1_1,"Answer 1", 1,1,true);
                            break;
                        case 2:
//                            lbl1_2.setText("Answer 2");
//                            decorateAnswerLabel(lbl1_2, true);
//                            MainWindow.nextQuestion(1);
//                            attempts=0;
//                            questionArea.setText(MainWindow.currentQuestion.generateRandomQuestion());
                            nextQUpdateElments(lbl1_2,"Answer 2", 1,2, true);
                            currentObjects=new CurrentObjects(lbl1_2,"Answer 2", 1,2, true);
                            break;
                        case 3:
//                            lbl1_3.setText("Answer 3");
//                            decorateAnswerLabel(lbl1_3, true);
//                            MainWindow.nextQuestion(1);
//                            attempts=0;
//                            questionArea.setText(MainWindow.currentQuestion.generateRandomQuestion());
                            nextQUpdateElments(lbl1_3,"Answer 3", 1,3,true);
                            currentObjects=new CurrentObjects(lbl1_3,"Answer 3", 1,3,true);
                            break;
                        case 4:
//                            lbl1_4.setText("Answer 4");
//                            decorateAnswerLabel(lbl1_4, true);
//                            MainWindow.nextQuestion(1);
//                            attempts=0;
//                            questionArea.setText(MainWindow.currentQuestion.generateRandomQuestion());
                            nextQUpdateElments(lbl1_4,"Answer 4", 1,4,true);
                            currentObjects=new CurrentObjects(lbl1_4,"Answer 4", 1,4,true);
                            break;
                        case 5:
//                            lbl1_5.setText("Answer 5");
//                            decorateAnswerLabel(lbl1_5, true);
//                            MainWindow.nextQuestion(1);
                            
                            nextQUpdateElments(lbl1_5,"Answer 5", 1,5, true);
                            currentObjects=new CurrentObjects(lbl1_5,"Answer 5", 1,5, true);
//                            attempts=0;
////                            questionArea.setText(MainWindow.currentQuestion.generateRandomQuestion());
//                            if(MainWindow.requirement>successAnswers){
//                                window.alert("You didn't reach the requirement of 3 good answers.");
//                                SVGFrame.dispose();
//                                successAnswers=0;
//                                MainWindow.myMain.setVisible(true);
//                            }else{
//                                window.alert("Congratulations!! You are passing to the Next Step");
//                                SVGFrame.dispose();
//                                MainWindow.nextLevel();
//                                SVGFrame.dispose();
//                                successAnswers=0;
//                                frameLevel2.setVisible(true);
//                                frameLevel2.setSize(691, 534);
//                                
//                                getQuestionArea2().setText(MainWindow.currentQuestion.generateRandomQuestion());
////                                MainWindow.drawHeroPhotoCurrentQuestion();
//                                drawHeroImageCurrentQuestion(MainWindow.dataHashMapHero.get(MainWindow.currentQuestion.getRandomCountryID()).getPhotoURL(),photoLabel,canvaspanel);
//                            }    
                            break;
                        default :
                        {
                            
                                
                            System.out.println("Default Answer");
                        }
                    }
              }else if(MainWindow.currentLevel==2){
                  
//                  window.alert("Got It");
                       decorateAnswerLabel(successLbl, true);
                       successShot.setText("Success Shot : "+(successAnswers+1));
                       
                       //check first if it's the 5th question answered
                       attempts=0;
//                            questionArea.setText(MainWindow.currentQuestion.generateRandomQuestion());
                       if(Question.questionNumber==5)
                            if(MainWindow.requirement>successAnswers){
                                window.alert("You didn't reach the requirement of 3 good answers.");
                                SVGFrame.dispose();
                                successAnswers=0;
                                stopTimer();
                                MainWindow.myMain.setVisible(true);
                            }else{
                                window.alert("Congratulations!! You are an African Continent Specialist Now!");
                                SVGFrame.dispose();
//                                MainWindow.nextLevel();
//                                SVGFrame.dispose();
                                stopTimer();
                                successAnswers=0;
                                attempts=0;
//                                frameLevel2.setVisible(true);
//                                frameLevel2.setSize(691, 534);
//                                Show the congratulations frame
//                                frameCongrat.setVisible(true);
//                                frameCongrat.setSize(477, 346);
                                drawCongratIcon();
                            }
                       
                        MainWindow.nextQuestion(2);
                        getQuestionArea2().setText(MainWindow.currentQuestion.generateRandomQuestion());
//                  MainWindow.drawHeroPhotoCurrentQuestion();
                        drawHeroImageCurrentQuestion(MainWindow.dataHashMapHero.get(MainWindow.currentQuestion.getRandomCountryID()).getPhotoURL(),photoLabel,canvaspanel);

              }   
//                     decorateAnswerLabel(lb1_1, true);
//               successAnswers++;             
                    
              }else{
//                  window.alert("Failed ");
//                      lb1_1.setText("Failed");
//                     
//                      decorateAnswerLabel(lb1_1, false);
                  attempts++;
                      
                  if(MainWindow.currentLevel==1){
                    switch(Question.questionNumber){
                        case 1:
                            lb1_1.setText("Answer 1");
                            decorateAnswerLabel(lb1_1, false);
//                            MainWindow.nextQuestion(1);
//                            questionArea.setText(MainWindow.currentQuestion.generateRandomQuestion());
                            fail=true;
                            break;
                        case 2:
                            lbl1_2.setText("Answer 2");
                            decorateAnswerLabel(lbl1_2, false);
//                            MainWindow.nextQuestion(1);
//                            questionArea.setText(MainWindow.currentQuestion.generateRandomQuestion());
                            fail=true;
                            break;
                        case 3:
                            lbl1_3.setText("Answer 3");
                            decorateAnswerLabel(lbl1_3, false);
//                            MainWindow.nextQuestion(1);
//                            questionArea.setText(MainWindow.currentQuestion.generateRandomQuestion());
                            fail=true;
                            break;
                        case 4:
                            lbl1_4.setText("Answer 4");
                            decorateAnswerLabel(lbl1_4, false);
//                            MainWindow.nextQuestion(1);
//                            questionArea.setText(MainWindow.currentQuestion.generateRandomQuestion());
                            fail=true;
                            break;
                        case 5:
                            lbl1_5.setText("Answer 5");
                            decorateAnswerLabel(lbl1_5, false);
//                            MainWindow.nextQuestion(1);
//                            questionArea.setText(MainWindow.currentQuestion.generateRandomQuestion());
                            fail=true;
                            lastQ=true;
                           if(attempts==3) 
//                            if(MainWindow.requirement>successAnswers){
//                                window.alert("You didn't reach the requirement of 3 good answers.");
//                                SVGFrame.dispose();
//                                successAnswers=0;
//                                attempts=0;
//                                getTimer().stop();
//                                MainWindow.myMain.setVisible(true);
//                            }else{
//                                window.alert("Congratulations!! You are passing to the Next Step");
//                                getTimer().stop();
//                                SVGFrame.dispose();
//                                
//                                MainWindow.nextLevel();
//                                successAnswers=0;
//                                attempts=0;
//                                SVGFrame.dispose();
//                                frameLevel2.setVisible(true);
//                                frameLevel2.setSize(691, 534);
//                                
//                                getQuestionArea2().setText(MainWindow.currentQuestion.generateRandomQuestion());
////                                MainWindow.drawHeroPhotoCurrentQuestion();
//                                drawHeroImageCurrentQuestion(MainWindow.dataHashMapHero.get(MainWindow.currentQuestion.getRandomCountryID()).getPhotoURL(),photoLabel,canvaspanel);
//
//                            }
                           faildAndMove();
                            break;
                        default :
                            {
                            
                                
                            System.out.println("Default Answer");
                        }
                    }
                }else if(MainWindow.currentLevel==2){
                    
                      decorateAnswerLabel(successLbl, false);
                       if(Question.questionNumber==5)
                            if(MainWindow.requirement>successAnswers){
                               if(attempts==3){
                                window.alert("You didn't reach the requirement of 3 good answers.");
                                SVGFrame.dispose();
                                successAnswers=0;
                                MainWindow.myMain.setVisible(true);
                               }
                            }else{
                               if(attempts==3){
                                window.alert("Congratulations!! You are an African Continent Specialist Now!");
                                SVGFrame.dispose();
//                                MainWindow.nextLevel();
//                                SVGFrame.dispose();
                                successAnswers=0;
                                attempts=0;
//                                frameLevel2.setVisible(true);
//                                frameLevel2.setSize(691, 534);
//                                Show the congratulations frame
                                frameCongrat.setVisible(true);
                                frameCongrat.setSize(477, 346);
                                drawCongratIcon();
                               }
                            }
                      
                }   
                       
                      if(attempts==3){
                          attempts=0;
                          if(MainWindow.currentLevel==1){
                          //Call Next Question
                              //before calling the next question, let's reset the timer
                              getTimer().stop();
                              initTimer();
                              fail=false;
                          MainWindow.nextQuestion(1);
                          questionArea.setText(MainWindow.currentQuestion.generateRandomQuestion());
                          }else if(MainWindow.currentLevel==2){
                              MainWindow.nextQuestion(2);
                              getQuestionArea2().setText(MainWindow.currentQuestion.generateRandomQuestion());
                              drawHeroImageCurrentQuestion(MainWindow.dataHashMapHero.get(MainWindow.currentQuestion.getRandomCountryID()).getPhotoURL(),photoLabel,canvaspanel);

                          }
                      }    
              }
            }catch(NullPointerException ex){
//                Node node=((Node)evt.getTarget()).getParentNode();
//                if(!node.getParentNode().equals(null))
//                    id=((Element)node.getParentNode()).getAttribute("id");
//                else
//                    id=((Element)node).getAttribute("id");
//                countryClicked=MainWindow.dataHashMap.get(id);     
//                window.alert("Country Clicked "+countryClicked.getName()+ " HERO "+countryClicked.getHero().getFullname()+" Deceased on "+countryClicked.getHero().getDeceased());
                ex.printStackTrace();
            }finally{
//              if(countryClicked.getHero().equals(null))
//              window.alert("Country Clicked "+countryClicked.getName());
        
          }
         
        }
    }
    
   public void drawHeroImageCurrentQuestion(String iconURL, JLabel label,JPanel panel){
       ImageIcon myIcon= new ImageIcon(iconURL);
        
//        myIcon.getP
        label.setIcon(myIcon);
        
//        panel.add(label);
        panel.repaint();
        heroDetails.setText(MainWindow.dataHashMapHero.get(MainWindow.currentQuestion.getRandomCountryID()).getComments());
         heroName.setText("Name : "+MainWindow.dataHashMapHero.get(MainWindow.currentQuestion.getRandomCountryID()).getFullname());
   }
   public void drawCongratIcon(){
       ImageIcon myIcon= new ImageIcon("svg/congratulations.gif");
//        
////        myIcon.getP
//        congratLbl.setIcon(myIcon);
//          congratPanel.repaint();
//        congratPanel=new Fireworks().getMainPanel();
//        frameCongrat=new Fireworks();
//        congratPanel.repaint();
        new Fireworks().setVisible(true);
//        panel.add(label);
//      frameCongrat.setContentPane(new Fireworks().getContentPane());
//        frameCongrat.pack();
   }
    
    public void decorateAnswerLabel(JLabel label,boolean status){
         ImageIcon myIcon;
         if(status){
              myIcon=new ImageIcon("svg/success_compressed.png");
              label.setIcon(myIcon);
              label.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.green, Color.green));
              
              label.setOpaque(true);
         }else{
             myIcon=new ImageIcon("svg/fail_compressed.png");
             label.setIcon(myIcon);
              label.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.red, Color.red));
              
              label.setOpaque(true);
              Toolkit.getDefaultToolkit().beep();
         }
             
    }
    
    public void nextQUpdateElments(JLabel _label,String _text,int _level,int _qnumber,boolean _decorate){
      
        _label.setText(_text);
        decorateAnswerLabel(_label, _decorate);
        attempts=0;
        if (_qnumber==5){
           attempts=0;
           _qnumber=0;
//                            questionArea.setText(MainWindow.currentQuestion.generateRandomQuestion());
                            if(MainWindow.requirement>successAnswers){
                                window.alert("You didn't reach the requirement of 3 good answers.");
                                SVGFrame.dispose();
                                successAnswers=0;
                                MainWindow.myMain.setVisible(true);
                            }else{
                                window.alert("Congratulations!! You are passing to the Next Step");
                                SVGFrame.dispose();
                                MainWindow.nextLevel();
                                SVGFrame.dispose();
                                successAnswers=0;
                                frameLevel2.setVisible(true);
                                frameLevel2.setSize(691, 534);
                                
                                stopTimer();
                                
                                getQuestionArea2().setText(MainWindow.currentQuestion.generateRandomQuestion());
//                                MainWindow.drawHeroPhotoCurrentQuestion();
                                drawHeroImageCurrentQuestion(MainWindow.dataHashMapHero.get(MainWindow.currentQuestion.getRandomCountryID()).getPhotoURL(),photoLabel,canvaspanel);
                            
                    }
        }else{
        
        MainWindow.nextQuestion(_level);
        attempts=0;
        questionArea.setText(MainWindow.currentQuestion.generateRandomQuestion());
        }
    }

    private static class CurrentObjects{
        private JLabel currentLabel;
        private String currentText;
        private int currentLevel;
        private int currentQNumber;
        private boolean paintLabel;

        public CurrentObjects(JLabel currentLabel, String currentText, int currentLevel, int currentQNumber, boolean paintLabel) {
            this.currentLabel = currentLabel;
            this.currentText = currentText;
            this.currentLevel = currentLevel;
            this.currentQNumber = currentQNumber;
            this.paintLabel = paintLabel;
        }

        

        public CurrentObjects() {
        }

        /**
         * @return the currentLabel
         */
        public JLabel getCurrentLabel() {
            return currentLabel;
        }

        /**
         * @param currentLabel the currentLabel to set
         */
        public void setCurrentLabel(JLabel currentLabel) {
            this.currentLabel = currentLabel;
        }

        /**
         * @return the currentText
         */
        public String getCurrentText() {
            return currentText;
        }

        /**
         * @param currentText the currentText to set
         */
        public void setCurrentText(String currentText) {
            this.currentText = currentText;
        }

        /**
         * @return the currentLevel
         */
        public int getCurrentLevel() {
            return currentLevel;
        }

        /**
         * @param currentLevel the currentLevel to set
         */
        public void setCurrentLevel(int currentLevel) {
            this.currentLevel = currentLevel;
        }

        /**
         * @return the currentQNumber
         */
        public int getCurrentQNumber() {
            return currentQNumber;
        }

        /**
         * @param currentQNumber the currentQNumber to set
         */
        public void setCurrentQNumber(int currentQNumber) {
            this.currentQNumber = currentQNumber;
        }

        /**
         * @return the paintLabel
         */
        public boolean isPaintLabel() {
            return paintLabel;
        }

        /**
         * @param paintLabel the paintLabel to set
         */
        public void setPaintLabel(boolean paintLabel) {
            this.paintLabel = paintLabel;
        }
        
        
    }
    
    public void initTimer(){
        setTime(MainWindow.time);
        TimerListener timerlistener= new TimerListener(getTime(),lbltimer_1);
       
        setTimer(new Timer(1000, timerlistener));
          
        getTimer().start();
   }
    
    public void startTimer(){
        try{
            getTimer().start();
        }catch(NullPointerException e){
            System.err.println("Timer not initialized." );
            e.printStackTrace();
        }
    }
    public void stopTimer(){
        try{
            getTimer().stop();
        }catch(NullPointerException e){
            System.err.println("Timer not initialized." );
            e.printStackTrace();
        }
    }
    
    public void faildAndMove(){
       
        if(MainWindow.requirement>successAnswers){
                                window.alert("You didn't reach the requirement of 3 good answers.");
                                SVGFrame.dispose();
                                successAnswers=0;
                                attempts=0;
                                lastQ=false;
                                Question.questionNumber=0;
                                getTimer().stop();
                                MainWindow.myMain.setVisible(true);
                            }else{
                                window.alert("Congratulations!! You are passing to the Next Step");
                                getTimer().stop();
                                SVGFrame.dispose();
                                
                                MainWindow.nextLevel();
                                successAnswers=0;
                                attempts=0;
                                SVGFrame.dispose();
                                frameLevel2.setVisible(true);
                                frameLevel2.setSize(691, 534);
                                
                                getQuestionArea2().setText(MainWindow.currentQuestion.generateRandomQuestion());
//                                MainWindow.drawHeroPhotoCurrentQuestion();
                                drawHeroImageCurrentQuestion(MainWindow.dataHashMapHero.get(MainWindow.currentQuestion.getRandomCountryID()).getPhotoURL(),photoLabel,canvaspanel);

                            }
    }
    
     public class TimerListener implements ActionListener{
        private int time;
        private JLabel label;
        public TimerListener(int _time, JLabel _lbl) {
            this.time=_time;
            this.label=_lbl;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            time--;
            if(time>=1){
                label.setText(""+time);
            }else{
                stopTimer();
                fail=true;
                Toolkit.getDefaultToolkit().beep();
                if(fail){
                    label.setText("00");
                    if(!lastQ){
                        try{
                            stopTimer();
                            initTimer();
                            attempts=0;
                            
                            
                        switch(Question.questionNumber){
                        case 1:
                            lb1_1.setText("Answer 1");
                            decorateAnswerLabel(lb1_1, false);
                            fail=true;
                            break;
                        case 2:
                            lbl1_2.setText("Answer 2");
                            decorateAnswerLabel(lbl1_2, false);
                            fail=true;
                            break;
                        case 3:
                            lbl1_3.setText("Answer 3");
                            decorateAnswerLabel(lbl1_3, false);
                            fail=true;
                            break;
                        case 4:
                            lbl1_4.setText("Answer 4");
                            decorateAnswerLabel(lbl1_4, false);
                            fail=true;
                            break;
                        case 5:
                            lbl1_5.setText("Answer 5");
                            decorateAnswerLabel(lbl1_5, false);
                            fail=true;
                            lastQ=true;
                           if(attempts<=3){ 
                           attempts=0; 
                            faildAndMove();                            
                           }
                            break;
                        default :
                            {
                                                            
                            System.out.println("Default Answer");
                        }
                    }
                     
                        
                         fail=false;
                         MainWindow.nextQuestion(1);
                          questionArea.setText(MainWindow.currentQuestion.generateRandomQuestion());
                        }catch(NullPointerException ex){
                            System.err.println("currentObjects in Fail are null ");
                            ex.printStackTrace();
                        }
                    }else{
                        stopTimer();
                        initTimer();
                        fail=false;
                        if(attempts<=3){
                            attempts=0;
                            faildAndMove();
                            lastQ=true;
                        }
                    }
                }else{
                    try{
                       nextQUpdateElments(currentObjects.getCurrentLabel(), currentObjects.getCurrentText(), currentObjects.getCurrentLevel(), 
                           currentObjects.getCurrentQNumber(), currentObjects.isPaintLabel());
                    }catch(NullPointerException ex){
                        
                        window.alert("You didn't click on the Map, the game will exit...");
                        System.err.println("currentObjects null ");
                        
                        SVGFrame.dispose();
                        successAnswers=0;
                        attempts=0;
                        getTimer().stop();
                        MainWindow.myMain.setVisible(true);
                        
                        //ex.printStackTrace();
                    }
                }
            
            }
        }
    }
}
