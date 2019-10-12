/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mecse;

import java.util.List;
import javax.faces.event.ValueChangeEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sathiya
 */
public class loginbeanTest {
    
    public loginbeanTest() {
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
     * Test of callServlet method, of class loginbean.
     */
    @Test
    public void testCallServlet() {
        System.out.println("\n");
        System.out.println("Student login test 1");
        loginbean instance = new loginbean();
        String name="uma";
        String password="uma";
        String expResult="Success";
        String result=instance.callServlet_temp(name,password);
        
        assertEquals(expResult, result);
        System.out.println("Success");
        /*
        try {
            assertEquals(expResult, result);
            System.out.println("Success");
        } 
        catch (AssertionError e) {
            System.out.println("Failed");
        }
        */
        
        System.out.println("\n");

    }
    
    
    @Test
    public void testCallServlet_1() {
        System.out.println("\n");
        System.out.println("Student login test 2");
        loginbean instance = new loginbean();
        String name="uma";
        String password="";
        String expResult="Failure";
        String result=instance.callServlet_temp(name,password);
        assertEquals(expResult, result);
        System.out.println("Success");
        /*
        try {
            assertEquals(expResult, result);
            System.out.println("Success");
        } 
        catch (AssertionError e) {
            System.out.println("Failed");
        }
        */
        
        System.out.println("\n");
    }
    
  // @Test
   // public void testCallServlet_2() {
    //   System.out.println("\n");
    //    System.out.println("Student login test 3");
      //  loginbean instance = new loginbean();
        //String name="sathya";
        //String password="sathya";
        //String expResult="Success";
        //String result=instance.callServlet_temp(name,password);
        //assertEquals(expResult, result);
        //System.out.println("Success");
        /*
        try {
            assertEquals(expResult, result);
            System.out.println("Success");
        } 
        catch (AssertionError e) {
            System.out.println("Failed");
        }
        */
        
        //System.out.println("\n");
    //}
    
    
   
    @Test
    public void testCallServlet1() {
        System.out.println("\n");
        System.out.println("Admin login test 1");
        loginbean instance = new loginbean();
        String name="admin";
        String password="admin";
        String expResult="Success";
        String result=instance.callServlet1_temp(name,password);
        assertEquals(expResult, result);
        System.out.println("Success");
        /*
        try {
            assertEquals(expResult, result);
            System.out.println("Success");
        } 
        catch (AssertionError e) {
            System.out.println("Failed");
        }
        */
        
        System.out.println("\n");
    }
    
    
    
    @Test
    public void testCallServlet1_1() {
        System.out.println("\n");
        System.out.println("Admin login test 2");
        loginbean instance = new loginbean();
        String name="admin";
        String password="";
        String expResult="Success";
        String result=instance.callServlet1_temp(name,password);
        assertEquals(expResult, result);
        System.out.println("Success");
        /*
        try {
            assertEquals(expResult, result);
            System.out.println("Success");
        } 
        catch (AssertionError e) {
            System.out.println("Failed");
        }
        */
        
        System.out.println("\n");
    }
    
    
    
    
    
    @Test
    public void testcallServlet0() {
        System.out.println("\n");
        System.out.println("Student score 1");
        loginbean instance = new loginbean();
        String gre_score="310.0";
        String toefl_score="120.0";
        String university_rating="10";
        String sop="10.0";
        String lop="10.0";
        String cgpa="10.0";
        String research="10.0";
        String expResult="Success";
        String result=instance.callServlet0_temp(gre_score,toefl_score,university_rating,sop,lop,cgpa,research);
        assertEquals(expResult, result);
        System.out.println("Success");
        /*
        try {
            assertEquals(expResult, result);
            System.out.println("Success");
        } 
        catch (AssertionError e) {
            System.out.println("Failed");
        }
        */
        System.out.println("\n");
    }
    
    
    @Test
    public void testcallServlet0_1() {
        System.out.println("\n");
        System.out.println("Student score 2");
        loginbean instance = new loginbean();
        String gre_score="310.0";
        String toefl_score="120.0";
        String university_rating="we";
        String sop="10.0";
        String lop="10.0";
        String cgpa="10.0";
        String research="10.0";
        String expResult="Success";
        String result=instance.callServlet0_temp(gre_score,toefl_score,university_rating,sop,lop,cgpa,research);
        assertEquals(expResult, result);
        System.out.println("Success");
        /*
        try {
            assertEquals(expResult, result);
            System.out.println("Success");
        } 
        catch (AssertionError e) {
            System.out.println("Failed");
        }
        */
        System.out.println("\n");
    }
    
}
