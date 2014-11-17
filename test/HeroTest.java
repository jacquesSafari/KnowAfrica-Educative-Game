/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
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
public class HeroTest {
    
    public HeroTest() {
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
     * Test of getComments method, of class Hero.
     */
    @Test
    public void testGetComments() {
        
        Hero instance = new Hero();
        instance.setComments("za");
        String expResult = "za";
        String result = instance.getComments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

   
    @Test
    public void testSetCountryID() {
        
        
        String countryID = "za";
        Hero instance = new Hero();
        
        instance.setCountryID(countryID);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCountryID method, of class Hero.
     */
    @Test
    public void testGetCountryID() {
        
        Hero instance = new Hero();
        instance.setCountryID("za");
        String expResult = "za";
        String result = instance.getCountryID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setFullname method, of class Hero.
     */
    @Test
    public void testSetFullname() {
        
        String fullname = "";
        Hero instance = new Hero();
        instance.setFullname(fullname);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setDob method, of class Hero.
     */
    @Test
    public void testSetDob() {
       
        Date dob = null;
        Hero instance = new Hero();
        instance.setDob(dob);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setPhotoURL method, of class Hero.
     */
    @Test
    public void testSetPhotoURL() {
        
        String photoURL = "";
        Hero instance = new Hero();
        instance.setPhotoURL(photoURL);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setDeceased method, of class Hero.
     */
    @Test
    public void testSetDeceased() {
        
        Date deceased = null;
        Hero instance = new Hero();
        instance.setDeceased(deceased);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getFullname method, of class Hero.
     */
    @Test
    public void testGetFullname() {
        
        Hero instance = new Hero();
        instance.setFullname("za");
        String expResult = "za";
        String result = instance.getFullname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getDob method, of class Hero.
     */
    @Test
    public void testGetDob() {
        
        Hero instance = new Hero();
        Date expResult = null;
        Date result = instance.getDob();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getDeceased method, of class Hero.
     */
    @Test
    public void testGetDeceased() {
        
        Hero instance = new Hero();
        Date expResult = null;
        Date result = instance.getDeceased();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPhotoURL method, of class Hero.
     */
    @Test
    public void testGetPhotoURL() {
        
        Hero instance = new Hero();
        String expResult = "za";
        instance.setPhotoURL("za");
        String result = instance.getPhotoURL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
    
}
