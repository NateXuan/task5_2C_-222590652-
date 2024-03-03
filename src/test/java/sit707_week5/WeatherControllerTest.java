package sit707_week5;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class WeatherControllerTest {
	
	private static WeatherController wController;
    private static double[] hourlyTemperatures;
    private static int nHours;

    @Before
    public void setUp() {
        if (wController == null) {
            wController = WeatherController.getInstance();
            nHours = wController.getTotalHours();
            hourlyTemperatures = new double[nHours];
            for (int i = 0; i < nHours; i++) {
                hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);
            }
        }
    }
    
	@Test
	public void testStudentIdentity() {
		String studentId = "222590652";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Wenzong Xuan";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");
		
		double minTemperature = Arrays.stream(hourlyTemperatures).min().getAsDouble();
        Assert.assertEquals(wController.getTemperatureMinFromCache(), minTemperature, 0.001);	
	}
	
	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");
		
		double maxTemperature = Arrays.stream(hourlyTemperatures).max().getAsDouble();
        Assert.assertEquals(wController.getTemperatureMaxFromCache(), maxTemperature, 0.001);
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");
		
		double sumTemp = Arrays.stream(hourlyTemperatures).sum();
        double averageTemp = sumTemp / nHours;
        Assert.assertEquals(wController.getTemperatureAverageFromCache(), averageTemp, 0.001);
	}
	
	@After
    public void tearDown() {
        wController.close();
    }
	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
