package sit707_week5;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

/**
 * Main entry of application.
 *
 */
public class Main {
    public static void main(String[] args) {
        WeatherController wController = WeatherController.getInstance();

        System.out.println("Temperature min: " + wController.getTemperatureMinFromCache());
        System.out.println("Temperature max: " + wController.getTemperatureMaxFromCache());
        System.out.println("Temperature avg: " + wController.getTemperatureAverageFromCache());
        System.out.println("Temperature at first hour: " + wController.getTemperatureForHour(1));

        // Simulate a fixed clock for testing purposes
        Instant currentInstant = Instant.now();
        wController.setClock(Clock.fixed(currentInstant, wController.getSystemDefaultZone()));

        Instant persistedTimestamp = wController.persistTemperature(10, 23.2);
        System.out.println("Persist time: " + persistedTimestamp + ", now: " + currentInstant);

        wController.close();
    }
}
