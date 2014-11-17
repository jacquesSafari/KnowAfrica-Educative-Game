/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class AnswerTest {
    
    public AnswerTest() {
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
     * Test of checkAnswer method, of class Answer.
     */
    
    
    @Test
    public void testCheckAnswer() {
        Answer instance = new Answer();  
        Question quest = new Question();
        quest.setRandomCountryID("za");
        boolean result = instance.checkAnswer("za", quest);
        boolean expResult = true;        
        assertEquals(expResult , result);
    }
    
}
