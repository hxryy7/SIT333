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

    @Test
    public void testFalseNumberIsEven() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(3));
    }

    @Test
    public void testTrueNumberIsEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(4));
    }

    @Test
    public void testIsEvenInverseProperty() {
        Assert.assertTrue(!WeatherAndMathUtils.isEven(7));
        Assert.assertTrue(WeatherAndMathUtils.isEven(6));
    }

    @Test
    public void testWeatherAdviceAllClear() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(20.0, 1.0));
    }

    @Test
    public void testWeatherAdviceWarnWind() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50.0, 2.0));
    }

    @Test
    public void testWeatherAdviceWarnRain() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(20.0, 5.0));
    }

    @Test
    public void testWeatherAdviceCancelWind() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(75.0, 2.0));
    }

    @Test
    public void testWeatherAdviceCancelRain() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(20.0, 6.1));
    }

    @Test
    public void testWeatherAdviceCancelBothConcerning() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(50.1, 4.1));
    }

    @Test
    public void testWeatherAdviceAtDangerousWindBoundary() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(70.0, 3.0));
    }

    @Test
    public void testWeatherAdviceAtDangerousRainBoundary() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(40.0, 6.0));
    }

    @Test
    public void testWeatherAdviceInvalidNegativeWind() {
        try {
            WeatherAndMathUtils.weatherAdvice(-1.0, 2.0);
            Assert.fail("Expected IllegalArgumentException for negative wind speed");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testWeatherAdviceInvalidNegativeRain() {
        try {
            WeatherAndMathUtils.weatherAdvice(10.0, -2.0);
            Assert.fail("Expected IllegalArgumentException for negative precipitation");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testIsPrimeWithTwo() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
    }

    @Test
    public void testIsPrimeWithPrimeNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(5));
    }

    @Test
    public void testIsPrimeWithEvenNonPrime() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(10));
    }

    @Test
    public void testIsPrimeWithOneOrLess() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(1));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(0));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(-5));
    }

    @Test
    public void testIsPrimeWithOddComposite() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(9));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(15));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(21));
    }

    @Test
    public void testIsPrimeWithOtherPrimes() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(3));
        Assert.assertTrue(WeatherAndMathUtils.isPrime(11));
        Assert.assertTrue(WeatherAndMathUtils.isPrime(13));
    }

    @Test
    public void testIsPrimeWithLargePrime() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(97));
    }
}