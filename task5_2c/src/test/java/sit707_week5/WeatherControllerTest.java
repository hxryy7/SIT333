package sit707_week5;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherControllerTest {

	@Test
	public void testStudentIdentity() {
		String studentId = "224234094";  // ✅ Replace with your actual ID
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Vardaan Chahal";  // ✅ Replace with your name
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");

		WeatherController wController = WeatherController.getInstance();

		int nHours = wController.getTotalHours();
		double minTemperature = 1000;
		for (int i = 0; i < nHours; i++) {
			double temperatureVal = wController.getTemperatureForHour(i + 1);
			if (minTemperature > temperatureVal) {
				minTemperature = temperatureVal;
			}
		}

		Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
		wController.close();
	}

	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");

		WeatherController wController = WeatherController.getInstance();

		int nHours = wController.getTotalHours();
		double maxTemperature = -1;
		for (int i = 0; i < nHours; i++) {
			double temperatureVal = wController.getTemperatureForHour(i + 1);
			if (maxTemperature < temperatureVal) {
				maxTemperature = temperatureVal;
			}
		}

		Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
		wController.close();
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");

		WeatherController wController = WeatherController.getInstance();

		int nHours = wController.getTotalHours();
		double sumTemp = 0;
		for (int i = 0; i < nHours; i++) {
			double temperatureVal = wController.getTemperatureForHour(i + 1);
			sumTemp += temperatureVal;
		}
		double averageTemp = sumTemp / nHours;

		Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
		wController.close();
	}

	@Test
	public void testTemperaturePersist() {
	    System.out.println("+++ testTemperaturePersist +++");

	    WeatherController wController = WeatherController.getInstance();

	    String persistTimeStr = wController.persistTemperature(10, 19.5);
	    String nowStr = new SimpleDateFormat("H:m:s").format(new Date());

	    System.out.println("Persist time: " + persistTimeStr + ", now: " + nowStr);

	    try {
	        SimpleDateFormat sdf = new SimpleDateFormat("H:m:s");
	        Date persistTime = sdf.parse(persistTimeStr);
	        Date now = sdf.parse(nowStr);

	        long timeDiffInMillis = Math.abs(now.getTime() - persistTime.getTime());

	        // Allow 1 second difference
	        Assert.assertTrue("Persist time mismatch", timeDiffInMillis <= 1000);
	    } catch (Exception e) {
	        e.printStackTrace();
	        Assert.fail("Exception during date parsing: " + e.getMessage());
	    }

	    wController.close();
	}

}
