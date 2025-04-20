package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vardaan Chahal
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

    // --- Equivalence Class Tests ---

    /**
     * D1 class: day between 1-28, normal month
     */
    @Test
    public void testDayBetween1And28InMarchShouldIncrementCorrectly() {
        DateUtil date = new DateUtil(15, 3, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    /**
     * D2 class: day = 29, February in leap year
     */
    @Test
    public void testFeb29LeapYearShouldIncrementToMarch1() {
        DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    /**
     * D2 class: day = 29, February in non-leap year (should throw exception)
     */
    @Test(expected = RuntimeException.class)
    public void testFeb29NonLeapYearShouldThrowException() {
        new DateUtil(29, 2, 2023);
    }

    /**
     * D3 class: day = 30, April (30-day month)
     */
    @Test
    public void testApril30ShouldIncrementToMay1() {
        DateUtil date = new DateUtil(30, 4, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
    }

    /**
     * D4 class: day = 31, July (31-day month)
     */
    @Test
    public void testJuly31ShouldIncrementToAugust1() {
        DateUtil date = new DateUtil(31, 7, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(8, date.getMonth());
    }

    /**
     * D4 class: day = 31, April (invalid date should throw exception)
     */
    @Test(expected = RuntimeException.class)
    public void testApril31ShouldThrowException() {
        new DateUtil(31, 4, 2024);
    }

    /**
     * Month = February, non-leap year, day = 28
     */
    @Test
    public void testFeb28NonLeapYearShouldIncrementToMarch1() {
        DateUtil date = new DateUtil(28, 2, 2023);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    /**
     * End of year test: 31st December should become 1st Jan next year
     */
    @Test
    public void testDec31ShouldIncrementToJan1NextYear() {
        DateUtil date = new DateUtil(31, 12, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2025, date.getYear());
    }

    /**
     * Beginning of year test: 1st Jan should decrement to 31st Dec previous year
     */
    @Test
    public void testJan1ShouldDecrementToDec31PreviousYear() {
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    /**
     * Leap year check: 2020 is a leap year, Feb 29 is valid
     */
    @Test
    public void testLeapYear2020Feb29Valid() {
        DateUtil date = new DateUtil(29, 2, 2020);
        System.out.println("Leap year test: " + date);
        Assert.assertEquals(29, date.getDay());
    }

    /**
     * Non-leap year check: Feb 29 invalid in 2021
     */
    @Test(expected = RuntimeException.class)
    public void testNonLeapYearFeb29Invalid() {
        new DateUtil(29, 2, 2021);
    }
}
