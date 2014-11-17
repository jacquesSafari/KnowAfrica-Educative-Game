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
public class CountryTest {
    
    public CountryTest() {
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
     * Test of setISOcode method, of class Country.
     */
    @Test
    public void testSetISOcode() {
        
        String ISOcode = "za";
        Country instance = new Country();
        instance.setISOcode(ISOcode);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setName method, of class Country.
     */
    @Test
    public void testSetName() {
        
        String name = "lumumba_cd";
        Country instance = new Country();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        
    }


    @Test
    public void testSetHero() {
       
        Hero hero = new Hero();
        Country instance = new Country();
        instance.setHero(hero);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getISOcode method, of class Country.
     */
    @Test
    public void testGetISOcode() {
        
        Country instance = new Country();
        instance.setISOcode("za");
        String expResult = "za";
        String result = instance.getISOcode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getName method, of class Country.
     */
    @Test
    public void testGetName() {
       
        Country instance = new Country();
        instance.setName("South Africa");
        String expResult = "South Africa";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
   
       
}
