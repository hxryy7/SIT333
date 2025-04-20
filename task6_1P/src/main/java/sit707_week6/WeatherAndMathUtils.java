package sit707_week6;

public class WeatherAndMathUtils {
    public static final double DANGEROUS_WINDSPEED = 70.0;
    public static final double DANGEROUS_RAINFALL = 6.0;
    public static final double CONCERNING_WINDSPEED = 45.0;
    public static final double CONCERNING_RAINFALL = 4.0;

    /**
     * Advises weather alert based on wind-speed and precipitation.
     *
     * @param windSpeed
     * @param precipitation
     * @return advice message: ALL CLEAR, WARN, or CANCEL
     */
    public static String weatherAdvice(double windSpeed, double precipitation) {
        if (windSpeed < 0 || precipitation < 0) {
            // Optional: Keep this condition uncovered for P task.
            throw new IllegalArgumentException();
        }

        String advice = "ALL CLEAR";

        if (windSpeed > DANGEROUS_WINDSPEED || precipitation > DANGEROUS_RAINFALL
                || (windSpeed > CONCERNING_WINDSPEED && precipitation > CONCERNING_RAINFALL)) {
            advice = "CANCEL";
        } else if (windSpeed > CONCERNING_WINDSPEED || precipitation > CONCERNING_RAINFALL) {
            advice = "WARN";
        }

        return advice;
    }

    /**
     * Checks if a number is even.
     *
     * @param a an integer number
     * @return true if even, false if odd
     */
    public static boolean isEven(int a) {
        return a % 2 == 0;
    }

    /**
     * Checks if a number is prime.
     *
     * @param n an integer number
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
