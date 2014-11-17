/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class QuestionTest {
    
    public QuestionTest() {
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
     * Test of getRandomNumber method, of class Question.
     */
    @Test
    public void testSetRandomCountryID() {
        
        String randomCountryID = "za";
        Question instance = new Question();
        instance.setRandomCountryID(randomCountryID);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    @Test
    public void testSetLevel() {
        
        int level = 0;
        Question instance = new Question();
        instance.setLevel(level);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    

    
    @Test
    public void testGenerateRandomQuestion() {
        
        Question instance =  new Question();
        instance.setLevel(3);
        String expResult = " Error in Question : Level Out of Bound ";
        String result = instance.generateRandomQuestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getLevel method, of class Question.
     */
    @Test
    public void testGetLevel() {
        
        Question instance = new Question();
        int expResult = 0;
        int result = instance.getLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

   
    @Test
    public void testGetRandomCountryID() {
        
        Question instance = new Question();
        String expResult = "za";
        instance.setRandomCountryID("za");
        String result = instance.getRandomCountryID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
    
}
