package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
    
    @Test
    public void testStudentIdentity() {
        String studentId = "s224234094";
        System.out.println(" Student ID: " + studentId);
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Harvardaan Chahal";
        System.out.println(" Student Name: " + studentName);
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testMaxJanuary31ShouldIncrementToFebruary1() {
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }
    
    @Test
    public void testMaxJanuary31ShouldDecrementToJanuary30() {
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }
    
    @Test
    public void testMinJanuary1ShouldIncrementToJanuary2() {
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }
    
    @Test
    public void testMinJanuary1ShouldDecrementToDecember31() {
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
    }
    
    @Test
    public void testMaxFebruary29ShouldIncrementToMarch1() {
        DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }
    
    @Test
    public void testMinFebruary1ShouldDecrementToJanuary31() {
        DateUtil date = new DateUtil(1, 2, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }
    
    @Test
    public void testMaxMarch31ShouldIncrementToApril1() {
        DateUtil date = new DateUtil(31, 3, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(4, date.getMonth());
    }
    
    @Test
    public void testMinMarch1ShouldDecrementToFebruary29() {
        DateUtil date = new DateUtil(1, 3, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }
    
    @Test
    public void testMaxDecember31ShouldIncrementToJanuary1NextYear() {
        DateUtil date = new DateUtil(31, 12, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2025, date.getYear());
    }
    
    @Test
    public void testMinDecember1ShouldDecrementToNovember30() {
        DateUtil date = new DateUtil(1, 12, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(11, date.getMonth());
    }
}