package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "224234094";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Vardaan Chahal";
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

    @Test(expected = IllegalArgumentException.class)
    public void testWeatherAdviceInvalidNegativeWind() {
        WeatherAndMathUtils.weatherAdvice(-1.0, 2.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWeatherAdviceInvalidNegativeRain() {
        WeatherAndMathUtils.weatherAdvice(10.0, -2.0);
    }

    @Test
    public void testIsPrimeWithTwo() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
    }

    @Test
    public void testIsPrimeWithNonPrime() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
    }

    @Test
    public void testIsPrimeWithPrimeNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(5));
    }

    @Test
    public void testIsPrimeWithOne() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(1));
    }
} 
