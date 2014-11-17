/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import org.apache.batik.swing.JSVGCanvas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Document;

/**
 *
 * @author admin
 */
public class SVGViewerTest {
    
    public SVGViewerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addLoadListerner method, of class SVGViewer.
     */
    @Test
    public void testAddLoadListerner() {
        
        SVGViewer instance = new SVGViewer();
        instance.addLoadListerner();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addTreeBuilderListener method, of class SVGViewer.
     */
    @Test
    public void testAddTreeBuilderListener() {
        
        SVGViewer instance = new SVGViewer();
        instance.addTreeBuilderListener();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCanvaspanel method, of class SVGViewer.
     */
    @Test
    public void testGetCanvaspanel() {
        
        SVGViewer instance = new SVGViewer();
        JPanel expResult = null;
        JPanel result = instance.getCanvaspanel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getSvgcanvas method, of class SVGViewer.
     */
   
    @Test
    public void testGetSvgfilename() {
        
        SVGViewer instance = new SVGViewer();
        String expResult = null;
        String result = instance.getSvgfilename();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setCanvaspanel method, of class SVGViewer.
     */
    @Test
    public void testSetCanvaspanel() {
        
        JPanel canvaspanel = null;
        SVGViewer instance = new SVGViewer();
        instance.setCanvaspanel(canvaspanel);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setSvgcanvas method, of class SVGViewer.
     */
    @Test
    public void testSetSvgcanvas() {
        
        JSVGCanvas svgcanvas = null;
        SVGViewer instance = new SVGViewer();
        instance.setSvgcanvas(svgcanvas);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setSvgfilename method, of class SVGViewer.
     */
    @Test
    public void testSetSvgfilename() {
        
        String svgfilename = "";
        SVGViewer instance = new SVGViewer();
        instance.setSvgfilename(svgfilename);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getQuestionArea method, of class SVGViewer.
     */
    @Test
    public void testGetQuestionArea() {
        
        SVGViewer instance = new SVGViewer();
        JTextArea expResult = null;
        JTextArea result = instance.getQuestionArea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setQuestionArea method, of class SVGViewer.
     */
    @Test
    public void testSetQuestionArea() {
        
        JTextArea questionArea = null;
        SVGViewer instance = new SVGViewer();
        instance.setQuestionArea(questionArea);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    

    /**
     * 
     */
    @Test
    public void testGetYourSelection2() {
        
        SVGViewer instance = new SVGViewer();
        JLabel expResult = null;
        JLabel result = instance.getYourSelection2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setYourSelection2 method, of class SVGViewer.
     */
    @Test
    public void testSetYourSelection2() {
        
        JLabel yourSelection2 = null;
        SVGViewer instance = new SVGViewer();
        instance.setYourSelection2(yourSelection2);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getQuestionArea2 method, of class SVGViewer.
     */
    @Test
    public void testGetQuestionArea2() {
        
        SVGViewer instance = new SVGViewer();
        JTextArea expResult = null;
        JTextArea result = instance.getQuestionArea2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setQuestionArea2 method, of class SVGViewer.
     */
    @Test
    public void testSetQuestionArea2() {
        
        JTextArea questionArea2 = null;
        SVGViewer instance = new SVGViewer();
        instance.setQuestionArea2(questionArea2);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPhotoLabel method, of class SVGViewer.
     */
    @Test
    public void testGetPhotoLabel() {
        
        SVGViewer instance = new SVGViewer();
        JLabel expResult = null;
        JLabel result = instance.getPhotoLabel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setPhotoLabel method, of class SVGViewer.
     */
    @Test
    public void testSetPhotoLabel() {
        
        JLabel photoLabel = null;
        SVGViewer instance = new SVGViewer();
        instance.setPhotoLabel(photoLabel);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getHeroDetails method, of class SVGViewer.
     */
    @Test
    public void testGetHeroDetails() {
        
        SVGViewer instance = new SVGViewer();
        JTextArea expResult = null;
        JTextArea result = instance.getHeroDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setHeroDetails method, of class SVGViewer.
     */
    @Test
    public void testSetHeroDetails() {
        
        JTextArea heroDetails = null;
        SVGViewer instance = new SVGViewer();
        instance.setHeroDetails(heroDetails);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getHeroName method, of class SVGViewer.
     */
    @Test
    public void testGetHeroName() {
        
        SVGViewer instance = new SVGViewer();
        JLabel expResult = null;
        JLabel result = instance.getHeroName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setHeroName method, of class SVGViewer.
     */
    @Test
    public void testSetHeroName() {
        
        JLabel heroName = null;
        SVGViewer instance = new SVGViewer();
        instance.setHeroName(heroName);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getSuccessLbl method, of class SVGViewer.
     */
    @Test
    public void testGetSuccessLbl() {
        
        SVGViewer instance = new SVGViewer();
        JLabel expResult = null;
        JLabel result = instance.getSuccessLbl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setSuccessLbl method, of class SVGViewer.
     */
    @Test
    public void testSetSuccessLbl() {
        
        JLabel successLbl = null;
        SVGViewer instance = new SVGViewer();
        instance.setSuccessLbl(successLbl);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getSuccessShot method, of class SVGViewer.
     */
    @Test
    public void testGetSuccessShot() {
        
        SVGViewer instance = new SVGViewer();
        JLabel expResult = null;
        JLabel result = instance.getSuccessShot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setSuccessShot method, of class SVGViewer.
     */
    @Test
    public void testSetSuccessShot() {
        
        JLabel successShot = null;
        SVGViewer instance = new SVGViewer();
        instance.setSuccessShot(successShot);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getFrameCongrat method, of class SVGViewer.
     */
    @Test
    public void testGetFrameCongrat() {
        
        SVGViewer instance = new SVGViewer();
        JFrame expResult = null;
        JFrame result = instance.getFrameCongrat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setFrameCongrat method, of class SVGViewer.
     */
    @Test
    public void testSetFrameCongrat() {
        
        JFrame frameCongrat = null;
        SVGViewer instance = new SVGViewer();
        instance.setFrameCongrat(frameCongrat);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getFrameHelp method, of class SVGViewer.
     */
    @Test
    public void testGetFrameHelp() {
        
        SVGViewer instance = new SVGViewer();
        JFrame expResult = null;
        JFrame result = instance.getFrameHelp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setFrameHelp method, of class SVGViewer.
     */
    @Test
    public void testSetFrameHelp() {
        
        JFrame frameHelp = null;
        SVGViewer instance = new SVGViewer();
        instance.setFrameHelp(frameHelp);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCongratLbl method, of class SVGViewer.
     */
    @Test
    public void testGetCongratLbl() {
        
        SVGViewer instance = new SVGViewer();
        JLabel expResult = null;
        JLabel result = instance.getCongratLbl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setCongratLbl method, of class SVGViewer.
     */
    @Test
    public void testSetCongratLbl() {
        
        JLabel congratLbl = null;
        SVGViewer instance = new SVGViewer();
        instance.setCongratLbl(congratLbl);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCongratPanel method, of class SVGViewer.
     */
    @Test
    public void testGetCongratPanel() {
        
        SVGViewer instance = new SVGViewer();
        JPanel expResult = null;
        JPanel result = instance.getCongratPanel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setCongratPanel method, of class SVGViewer.
     */
    @Test
    public void testSetCongratPanel() {
        
        JPanel congratPanel = null;
        SVGViewer instance = new SVGViewer();
        instance.setCongratPanel(congratPanel);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getLbltimer_1 method, of class SVGViewer.
     */
    @Test
    public void testGetLbltimer_1() {
        
        SVGViewer instance = new SVGViewer();
        JLabel expResult = null;
        JLabel result = instance.getLbltimer_1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setLbltimer_1 method, of class SVGViewer.
     */
    @Test
    public void testSetLbltimer_1() {
        
        JLabel lbltimer_1 = null;
        SVGViewer instance = new SVGViewer();
        instance.setLbltimer_1(lbltimer_1);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTime method, of class SVGViewer.
     */
    @Test
    public void testGetTime() {
        
        SVGViewer instance = new SVGViewer();
        int expResult = 0;
        int result = instance.getTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setTime method, of class SVGViewer.
     */
    @Test
    public void testSetTime() {
        
        int time = 0;
        SVGViewer instance = new SVGViewer();
        instance.setTime(time);
        // TODO review the generated test code and remove the default call to fail.
        
    }

   
    @Test
    public void testSetTimer() {
        
        Timer timer = null;
        SVGViewer instance = new SVGViewer();
        instance.setTimer(timer);
        // TODO review the generated test code and remove the default call to fail.
        
    }

   
}
