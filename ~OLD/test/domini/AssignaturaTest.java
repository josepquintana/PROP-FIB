package domini;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AssignaturaTest {
    
    public AssignaturaTest() {
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
     * Test of equals method, of class Assignatura.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Assignatura a = new Assignatura("123", "PROP", 7.5, 2, false);
        Assignatura instance = new Assignatura("123", "PROP", 7.5, 2, false);
        boolean expResult = true;
        boolean result = instance.equals(a);
        assertEquals(expResult, result);
        expResult = false;
        Assignatura a2 = new Assignatura("124", "IES", 7.5, 2, false);
        result = instance.equals(a2);
        assertEquals(expResult, result);
    }

    /**
     * Test of existeixCorrequisit method, of class Assignatura.
     */
    @Test
    public void testExisteixCorrequisit_Assignatura() {
        System.out.println("existeixCorrequisit");
        ArrayList<String> correq = new ArrayList<>();
        correq.add("124");
        correq.add("122");
        ArrayList<Grup> grups = new ArrayList<>();
        Grup G = new Grup("321", 10, 90, 3, 4);
        grups.add(G);
        Grup G2 = new Grup("322", 20, 90, 3, 4);
        grups.add(G2);
        Assignatura instance = new Assignatura("123", "PROP", 7.5, 2, correq, grups, false);
        Assignatura assig = new Assignatura("124", "IES", 7.5, 2, false);
        boolean expResult = true;
        boolean result = instance.existeixCorrequisit(assig);
        assertEquals(expResult, result);
        expResult = false;
        Assignatura assig2 = new Assignatura("125", "PRO1", 7.5, 2, false);
        result = instance.existeixCorrequisit(assig2);
    }

    /**
     * Test of existeixCorrequisit method, of class Assignatura.
     */
    @Test
    public void testExisteixCorrequisit_String() {
        System.out.println("existeixCorrequisit");
        String codi = "124";
        ArrayList<String> correq = new ArrayList<>();
        correq.add("124");
        correq.add("122");
        ArrayList<Grup> grups = new ArrayList<>();
        Grup G = new Grup("321", 10, 90, 3, 4);
        grups.add(G);
        Grup G2 = new Grup("322", 20, 90, 3, 4);
        grups.add(G2);
        Assignatura instance = new Assignatura("123", "PROP", 7.5, 2, correq, grups, false);
        boolean expResult = true;
        boolean result = instance.existeixCorrequisit(codi);
        assertEquals(expResult, result);
        expResult = false;
        codi = "125";
        result = instance.existeixCorrequisit(codi);
        assertEquals(expResult, result);
    }

    /**
     * Test of afegirCorrequisitAssignatura method, of class Assignatura.
     */
    @Test
    public void testAfegirCorrequisitAssignatura_Assignatura() throws Exception {
        System.out.println("afegirCorrequisitAssignatura");
        Assignatura a = new Assignatura("123", "IES", 7.5, 2, false);
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, false);
        instance.afegirCorrequisitAssignatura(a);
        String expResult = "123";
        String result = instance.getCorrequisit(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of afegirCorrequisitAssignatura method, of class Assignatura.
     */
    @Test
    public void testAfegirCorrequisitAssignatura_String() throws Exception {
        System.out.println("afegirCorrequisitAssignatura");
        String codi = "123";
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, false);
        instance.afegirCorrequisitAssignatura(codi);
        String expResult = "123";
        String result = instance.getCorrequisit(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminarCorrequisitAssignatura method, of class Assignatura.
     */
    @Test
    public void testEliminarCorrequisitAssignatura_Assignatura() {
        System.out.println("eliminarCorrequisitAssignatura");
        ArrayList<String> correq = new ArrayList<>();
        correq.add("123");
        correq.add("122");
        ArrayList<Grup> grups = new ArrayList<>();
        Grup G = new Grup("321", 10, 90, 3, 4);
        grups.add(G);
        Grup G2 = new Grup("322", 20, 90, 3, 4);
        grups.add(G2);
        Assignatura a = new Assignatura("123", "IES", 7.5, 2, false);
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, correq, grups, false);
        instance.eliminarCorrequisitAssignatura(a);
        int expResult = 1;
        int result = instance.getCorrequisits().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminarCorrequisitAssignatura method, of class Assignatura.
     */
    @Test
    public void testEliminarCorrequisitAssignatura_String() {
        System.out.println("eliminarCorrequisitAssignatura");
        String codi = "123";
        ArrayList<String> correq = new ArrayList<>();
        correq.add("123");
        correq.add("122");
        ArrayList<Grup> grups = new ArrayList<>();
        Grup G = new Grup("321", 10, 90, 3, 4);
        grups.add(G);
        Grup G2 = new Grup("322", 20, 90, 3, 4);
        grups.add(G2);
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, correq, grups, false);
        instance.eliminarCorrequisitAssignatura(codi);
        int expResult = 1;
        int result = instance.getCorrequisits().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of existeixGrup method, of class Assignatura.
     */
    @Test
    public void testExisteixGrup_Grup() {
        System.out.println("existeixGrup");
        Grup g = new Grup("300", 10, 90, 3, 2);
        Grup g2 = new Grup("301", 20, 90, 3, 2);
        Grup g3 = new Grup("302", 30, 90, 3, 2);
        Grup g4 = new Grup("303", 40, 90, 3, 2);
        ArrayList<Grup> grups = new ArrayList<>();
        grups.add(g);
        grups.add(g2);
        grups.add(g3);
        ArrayList<String> correq = new ArrayList<>();        
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, correq, grups, false);
        boolean expResult = true;
        boolean result = instance.existeixGrup(g);
        assertEquals(expResult, result);
        expResult = false;
        result = instance.existeixGrup(g4);
        assertEquals(expResult, result);
    }

    /**
     * Test of existeixGrup method, of class Assignatura.
     */
    @Test
    public void testExisteixGrup_int() {
        System.out.println("existeixGrup");
        Grup g = new Grup("300", 10, 90, 3, 2);
        Grup g2 = new Grup("301", 20, 90, 3, 2);
        Grup g3 = new Grup("302", 30, 90, 3, 2);
        ArrayList<Grup> grups = new ArrayList<>();
        grups.add(g);
        grups.add(g2);
        grups.add(g3);
        ArrayList<String> correq = new ArrayList<>();        
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, correq, grups, false);
        boolean expResult = true;
        boolean result = instance.existeixGrup(10);
        assertEquals(expResult, result);
        expResult = false;
        result = instance.existeixGrup(50);
        assertEquals(expResult, result);
    }

    /**
     * Test of afegirGrupAssignatura method, of class Assignatura.
     */
    @Test
    public void testAfegirGrupAssignatura() throws Exception {
        System.out.println("afegirGrupAssignatura");
        Grup g = new Grup("300", 10, 90, 3, 2);
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, false);
        instance.afegirGrupAssignatura(g);
        boolean expResult = true;
        boolean result = instance.existeixGrup(g);
        assertEquals(expResult, result);
        expResult = false;
        result = instance.existeixGrup(20);
        assertEquals(expResult, result);        
    }

    /**
     * Test of eliminarGrupAssignatura method, of class Assignatura.
     */
    @Test
    public void testEliminarGrupAssignatura_Grup() {
        System.out.println("eliminarGrupAssignatura");
        Grup g = new Grup("300", 10, 90, 3, 2);
        Grup g2 = new Grup("301", 20, 90, 3, 2);
        Grup g3 = new Grup("302", 30, 90, 3, 2);
        ArrayList<Grup> grups = new ArrayList<>();
        grups.add(g);
        grups.add(g2);
        grups.add(g3);
        ArrayList<String> correq = new ArrayList<>();        
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, correq, grups, false);
        instance.eliminarGrupAssignatura(g);
        boolean expResult = false;
        boolean result = instance.existeixGrup(g);
        assertEquals(expResult, result);
        int result2 = 2;
        int expResult2 = instance.getGrups().size();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of eliminarGrupAssignatura method, of class Assignatura.
     */
    @Test
    public void testEliminarGrupAssignatura_int() {
        System.out.println("eliminarGrupAssignatura");
        int i = 0;
        Grup g = new Grup("300", 10, 90, 3, 2);
        Grup g2 = new Grup("301", 20, 90, 3, 2);
        Grup g3 = new Grup("302", 30, 90, 3, 2);
        ArrayList<Grup> grups = new ArrayList<>();
        grups.add(g);
        grups.add(g2);
        grups.add(g3);
        ArrayList<String> correq = new ArrayList<>();        
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, correq, grups, false);
        instance.eliminarGrupAssignatura(i);
        boolean expResult = false;
        boolean result = instance.existeixGrup(g);
        assertEquals(expResult, result);
        int result2 = 2;
        int expResult2 = instance.getGrups().size();
        assertEquals(expResult2, result2);
    }
    /**
     * Test of teCorrequisits method, of class Assignatura.
     */
    @Test
    public void testTeCorrequisits() {
        System.out.println("teCorrequisits");
        ArrayList<String> correq = new ArrayList<>();
        ArrayList<Grup> grups = new ArrayList<>();
        correq.add("123");
        correq.add("122");
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, correq, grups, false);
        boolean expResult = true;
        boolean result = instance.teCorrequisits();
        assertEquals(expResult, result);
        Assignatura instance2 = new Assignatura();
        expResult = false;
        result = instance2.teCorrequisits();
        assertEquals(expResult, result);
    }

    /**
     * Test of teGrups method, of class Assignatura.
     */
    @Test
    public void testTeGrups() {
        System.out.println("teGrups");
        Grup g = new Grup("300", 10, 90, 3, 2);
        Grup g2 = new Grup("301", 20, 90, 3, 2);
        Grup g3 = new Grup("302", 30, 90, 3, 2);
        ArrayList<Grup> grups = new ArrayList<>();
        grups.add(g);
        grups.add(g2);
        grups.add(g3);
        ArrayList<String> correq = new ArrayList<>();        
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, correq, grups, false);
        boolean expResult = true;
        boolean result = instance.teGrups();
        assertEquals(expResult, result);       
    }

    /**
     * Test of setCodi method, of class Assignatura.
     */
    @Test
    public void testSetCodi() {
        System.out.println("setCodi");
        String codi = "123";
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, false);
        instance.setCodi(codi);
        String expResult = "123";
        String result = instance.getCodi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNom method, of class Assignatura.
     */
    @Test
    public void testSetNom() {
        System.out.println("setNom");
        String nom = "IES";
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, false);
        instance.setNom(nom);
        String expResult = "IES";
        String result = instance.getNom();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCredits method, of class Assignatura.
     */
    @Test
    public void testSetCredits() {
        System.out.println("setCredits");
        double credits = 6.5;
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, false);
        instance.setCredits(credits);
        double expResult = 6.5;
        double result = instance.getCredits();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of setNivell method, of class Assignatura.
     */
    @Test
    public void testSetNivell() {
        System.out.println("setNivell");
        int nivell = 4;
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, false);
        instance.setNivell(nivell);
        int expResult = 4;
        int result = instance.getNivell();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLab method, of class Assignatura.
     */
    @Test
    public void testSetLab() {
        System.out.println("setLab");
        boolean ordinadors = true;
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, false);
        instance.setLab(ordinadors);
        Boolean expResult = true;
        Boolean result = instance.isLab();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCorrequisits method, of class Assignatura.
     */
    @Test
    public void testSetCorrequisits() {
        System.out.println("setCorrequisits");
        ArrayList<String> correqs = new ArrayList<>();
        correqs.add("234");
        correqs.add("235");
        ArrayList<String> correq = new ArrayList<>();
        ArrayList<Grup> grups = new ArrayList<>();
        correq.add("123");
        correq.add("122");
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, correq, grups, false);
        instance.setCorrequisits(correqs);
        String expResult = "234";
        String result = instance.getCorrequisit(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of setGrups method, of class Assignatura.
     */
    @Test
    public void testSetGrups() {
        System.out.println("setGrups");
        ArrayList<Grup> grups = new ArrayList<>();
        Grup g = new Grup("300", 10, 90, 3, 2);
        Grup g2 = new Grup("301", 20, 90, 3, 2);
        Grup g3 = new Grup("302", 30, 90, 3, 2);
        Grup g4 = new Grup("500", 50, 90, 3, 2);
        Grup g5 = new Grup("501", 60, 90, 3, 2);
        
        ArrayList<Grup> grups2 = new ArrayList<>();
        grups2.add(g4);
        grups2.add(g5);
        grups.add(g);
        grups.add(g2);
        grups.add(g3);
        ArrayList<String> correq = new ArrayList<>();        
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, correq, grups, false);
        instance.setGrups(grups2);
        int expResult = 50;
        int result = instance.getGrup(0).getNumGrup();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCodi method, of class Assignatura.
     */
    @Test
    public void testGetCodi() {
        System.out.println("getCodi");
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, false);
        String expResult = "124";
        String result = instance.getCodi();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNom method, of class Assignatura.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, false);
        String expResult = "PROP";
        String result = instance.getNom();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCredits method, of class Assignatura.
     */
    @Test
    public void testGetCredits() {
        System.out.println("getCredits");
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, false);
        double expResult = 7.5;
        double result = instance.getCredits();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getNivell method, of class Assignatura.
     */
    @Test
    public void testGetNivell() {
        System.out.println("getNivell");
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, false);
        int expResult = 3;
        int result = instance.getNivell();
        assertEquals(expResult, result);
    }

    /**
     * Test of isLab method, of class Assignatura.
     */
    @Test
    public void testIsLab() {
        System.out.println("isLab");
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, true);
        boolean expResult = true;
        boolean result = instance.isLab();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSessionsLab method, of class Assignatura.
     */
    @Test
    public void testGetSessionsLab() {
        System.out.println("getSessionsLab");
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, false);
        int expResult = (int)(7.5/1.5)/2;
        int result = instance.getSessionsLab();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSessionsTeoria method, of class Assignatura.
     */
    @Test
    public void testGetSessionsTeoria() {
        System.out.println("getSessionsTeoria");
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, false);
        int hores = (int)(7.5/1.5);
        if(hores%2 != 0) {
            ++hores;         
        }
        int expResult = hores/2;
        int result = instance.getSessionsTeoria();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCorrequisits method, of class Assignatura.
     */
    @Test
    public void testGetCorrequisits() {
        System.out.println("getCorrequisits");
        ArrayList<String> correq = new ArrayList<>();
        ArrayList<Grup> grups = new ArrayList<>();
        correq.add("123");
        correq.add("122");
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, correq, grups, false);
        ArrayList<String> expResult = correq;
        ArrayList<String> result = instance.getCorrequisits();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCorrequisit method, of class Assignatura.
     */
    @Test
    public void testGetCorrequisit() {
        System.out.println("getCorrequisit");
        int i = 0;
        ArrayList<String> correq = new ArrayList<>();
        ArrayList<Grup> grups = new ArrayList<>();
        correq.add("123");
        correq.add("122");
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, correq, grups, false);
        String expResult = "123";
        String result = instance.getCorrequisit(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGrups method, of class Assignatura.
     */
    @Test
    public void testGetGrups() {
        System.out.println("getGrups");
        ArrayList<Grup> grups = new ArrayList<>();
        Grup g = new Grup("300", 10, 90, 3, 2);
        Grup g2 = new Grup("301", 20, 90, 3, 2);
        Grup g3 = new Grup("302", 30, 90, 3, 2);
        grups.add(g);
        grups.add(g2);
        grups.add(g3);
        ArrayList<String> correq = new ArrayList<>();        
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, correq, grups, false);
        ArrayList<Grup> expResult = grups;
        ArrayList<Grup> result = instance.getGrups();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGrup method, of class Assignatura.
     */
    @Test
    public void testGetGrup() {
        System.out.println("getGrup");
        int i = 0;
        ArrayList<Grup> grups = new ArrayList<>();
        Grup g = new Grup("300", 10, 90, 3, 2);
        Grup g2 = new Grup("301", 20, 90, 3, 2);
        Grup g3 = new Grup("302", 30, 90, 3, 2);
        grups.add(g);
        grups.add(g2);
        grups.add(g3);
        ArrayList<String> correq = new ArrayList<>();        
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, correq, grups, false);
        Grup expResult = g;
        Grup result = instance.getGrup(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCapacitatAssignatura method, of class Assignatura.
     */
    @Test
    public void testGetCapacitatAssignatura() {
        System.out.println("getCapacitatAssignatura");
        ArrayList<Grup> grups = new ArrayList<>();
        Grup g = new Grup("300", 10, 90, 3, 2);
        Grup g2 = new Grup("301", 20, 90, 3, 2);
        Grup g3 = new Grup("302", 30, 90, 3, 2);
        grups.add(g);
        grups.add(g2);
        grups.add(g3);
        ArrayList<String> correq = new ArrayList<>();        
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, correq, grups, false);
        int expResult = 270;
        int result = instance.getCapacitatAssignatura();
        assertEquals(expResult, result);
    }

    /**
     * Test of restarHoraTeo method, of class Assignatura.
     */
    @Test
    public void testRestarHoraTeo() {
        System.out.println("restarHoraTeo");
        Assignatura instance = new Assignatura("124", "PROP", 7.5, 3, false);
        instance.restarHoraTeo();
        int expResult = 2;
        int result = instance.getSessionsTeoria();
        assertEquals(expResult, result);
    }

    
}
