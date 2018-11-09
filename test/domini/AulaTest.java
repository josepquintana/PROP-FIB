/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domini;

import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jordi.donadeu
 */
public class AulaTest {
    
    public AulaTest() {
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
     * Test of equals method, of class Aula.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Aula a = new Aula("123", 10);
        Aula instance = new Aula("124", 11);
        boolean expResult = false;
        boolean result = instance.equals(a);
        assertEquals(expResult, result);
        Aula a2 = new Aula("124", 11);
        expResult = true;
        result = instance.equals(a2);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCodi method, of class Aula.
     */
    @Test
    public void testSetCodi() {
        System.out.println("setCodi");
        String codi = "123";
        Aula instance = new Aula("124", 23);
        instance.setCodi("123");
        String expResult = "123";
        String result = instance.getCodi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCapacitat method, of class Aula.
     */
    @Test
    public void testSetCapacitat() {
        System.out.println("setCapacitat");
        int capacitat = 10;
        Aula instance = new Aula("123", 25);
        int expResult = 10;
        instance.setCapacitat(capacitat);
        int result = instance.getCapacitat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCodi method, of class Aula.
     */
    @Test
    public void testGetCodi() {
        System.out.println("getCodi");
        Aula instance = new Aula("123", 25);
        String expResult = "123";
        String result = instance.getCodi();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCapacitat method, of class Aula.
     */
    @Test
    public void testGetCapacitat() {
        System.out.println("getCapacitat");
        Aula instance = new Aula("123", 25);
        int expResult = 25;
        int result = instance.getCapacitat();
        assertEquals(expResult, result);
    }

    /**
     * Test of printAula method, of class Aula no cal fer test, només és un println
     
    @Test
    public void testPrintAula() {
        System.out.println("printAula");
        Aula instance = new Aula();
        instance.printAula();

    }
    */
    
}
