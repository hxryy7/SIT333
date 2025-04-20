package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "224234094";
        System.out.println("Testing Student ID: " + studentId);
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Vardaan Chahal";
        System.out.println("Testing Student Name: " + studentName);
        Assert.assertNotNull("Student name is null", studentName);
    }

    // ---------- isEven Tests ----------
    @Test
    public void testFalseNumberIsEven() {
        System.out.println("Testing isEven with 3 (expected: false)");
        Assert.assertFalse(WeatherAndMathUtils.isEven(3));
    }

    @Test
    public void testTrueNumberIsEven() {
        System.out.println("Testing isEven with 4 (expected: true)");
        Assert.assertTrue(WeatherAndMathUtils.isEven(4));
    }

    // ---------- weatherAdvice Tests ----------
    @Test
    public void testWeatherAdviceAllClear() {
        System.out.println("Testing weatherAdvice with normal conditions (expected: ALL CLEAR)");
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(20.0, 1.0));
    }

    @Test
    public void testWeatherAdviceWarnWind() {
        System.out.println("Testing weatherAdvice with wind > 45 (expected: WARN)");
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50.0, 2.0));
    }

    @Test
    public void testWeatherAdviceWarnRain() {
        System.out.println("Testing weatherAdvice with rain > 4 (expected: WARN)");
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(20.0, 5.0));
    }

    @Test
    public void testWeatherAdviceCancelWind() {
        System.out.println("Testing weatherAdvice with wind > 70 (expected: CANCEL)");
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(75.0, 2.0));
    }

    @Test
    public void testWeatherAdviceCancelRain() {
        System.out.println("Testing weatherAdvice with rain > 6 (expected: CANCEL)");
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(20.0, 6.1));
    }

    @Test
    public void testWeatherAdviceCancelBothConcerning() {
        System.out.println("Testing weatherAdvice with wind > 45 and rain > 4 (expected: CANCEL)");
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(50.1, 4.1));
    }

    @Test
    public void testWeatherAdviceInvalidNegativeWind() {
        System.out.println("Testing weatherAdvice with negative wind (expected: Exception)");
        try {
            WeatherAndMathUtils.weatherAdvice(-1.0, 2.0);
            Assert.fail("Expected IllegalArgumentException for negative wind speed");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception for negative wind.");
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testWeatherAdviceInvalidNegativeRain() {
        System.out.println("Testing weatherAdvice with negative rain (expected: Exception)");
        try {
            WeatherAndMathUtils.weatherAdvice(10.0, -2.0);
            Assert.fail("Expected IllegalArgumentException for negative precipitation");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception for negative rain.");
            Assert.assertTrue(true);
        }
    }

    // ---------- isPrime Tests ----------
    @Test
    public void testIsPrimeWithTwo() {
        System.out.println("Testing isPrime with 2 (expected: true)");
        Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
    }

    @Test
    public void testIsPrimeWithPrimeNumber() {
        System.out.println("Testing isPrime with 5 (expected: true)");
        Assert.assertTrue(WeatherAndMathUtils.isPrime(5));
    }

    @Test
    public void testIsPrimeWithEvenNonPrime() {
        System.out.println("Testing isPrime with 4 and 10 (expected: false)");
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(10));
    }

    @Test
    public void testIsPrimeWithOneOrLess() {
        System.out.println("Testing isPrime with 1, 0, -5 (expected: false)");
        Assert.assertFalse(WeatherAndMathUtils.isPrime(1));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(0));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(-5));
    }

    @Test
    public void testIsPrimeWithOddComposite() {
        System.out.println("Testing isPrime with 9, 15, 21 (expected: false)");
        Assert.assertFalse(WeatherAndMathUtils.isPrime(9));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(15));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(21));
    }

    @Test
    public void testIsPrimeWithOtherPrimes() {
        System.out.println("Testing isPrime with 3, 11, 13 (expected: true)");
        Assert.assertTrue(WeatherAndMathUtils.isPrime(3));
        Assert.assertTrue(WeatherAndMathUtils.isPrime(11));
        Assert.assertTrue(WeatherAndMathUtils.isPrime(13));
    }
}
