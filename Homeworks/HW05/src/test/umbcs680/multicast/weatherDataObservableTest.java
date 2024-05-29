package umbcs680.multicast;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class weatherDataObservableTest {
    //Notify Observers Tests
    @Test
    public void exponential_Smoothing_Observer_On_Weather_Data_Test(){
        weatherDataObservable weatherdataobservable = new weatherDataObservable();
        ExponentialSmoothingObserver exponentialSmoothingObserver = new ExponentialSmoothingObserver(0.5);
        weatherdataobservable.addObserver(exponentialSmoothingObserver);
        weatherdataobservable.notifyObservers(new weatherEvent(List.of(25.0, 30.0, 35.0, 40.0)));
        assertEquals(29.375, exponentialSmoothingObserver.getForecast());
    }
    @Test
    public void moving_Average_Observer_On_Weather_Data_Test(){
        weatherDataObservable weatherdataobservable = new weatherDataObservable();
        MovingAverageObserver movingAverageObserver = new MovingAverageObserver(3);
        weatherdataobservable.addObserver(movingAverageObserver);
        weatherdataobservable.notifyObservers(new weatherEvent(List.of(25.0, 30.0, 35.0, 40.0)));
        assertEquals(35.0, movingAverageObserver.getForecast());
    }
    @Test
    public void linear_Regression_Observer_On_Weather_Data_Test(){
        weatherDataObservable weatherdataobservable = new weatherDataObservable();
        LinearRegressionObserver linearRegressionObserver = new LinearRegressionObserver();
        weatherdataobservable.addObserver(linearRegressionObserver);
        weatherdataobservable.notifyObservers(new weatherEvent(List.of(25.0, 30.0, 35.0, 40.0)));
        assertEquals(45.0, linearRegressionObserver.getForecast());
    }

    //Test cases for other public methods

    @Test
    public void add_Observer_Test(){
        weatherDataObservable weatherdataobservable = new weatherDataObservable();
        assertEquals(0, weatherdataobservable.countObservers());
        LinearRegressionObserver linearRegressionObserver = new LinearRegressionObserver();
        weatherdataobservable.addObserver(linearRegressionObserver);
        assertEquals(1, weatherdataobservable.countObservers());
        assertTrue(weatherdataobservable.getWeatherObservers().contains(linearRegressionObserver));
        MovingAverageObserver movingAverageObserver = new MovingAverageObserver(3);
        weatherdataobservable.addObserver(movingAverageObserver);
        assertEquals(2, weatherdataobservable.countObservers());
        assertTrue(weatherdataobservable.getWeatherObservers().contains(movingAverageObserver));
        ExponentialSmoothingObserver exponentialSmoothingObserver = new ExponentialSmoothingObserver(0.5);
        weatherdataobservable.addObserver(exponentialSmoothingObserver);
        assertEquals(3, weatherdataobservable.countObservers());
        assertTrue(weatherdataobservable.getWeatherObservers().contains(exponentialSmoothingObserver));
    }

    @Test
    public void remove_Observer_Test(){
        weatherDataObservable weatherdataobservable = new weatherDataObservable();
        assertEquals(0, weatherdataobservable.countObservers());
        LinearRegressionObserver linearRegressionObserver = new LinearRegressionObserver();
        weatherdataobservable.addObserver(linearRegressionObserver);
        assertEquals(1, weatherdataobservable.countObservers());
        assertTrue(weatherdataobservable.getWeatherObservers().contains(linearRegressionObserver));
        MovingAverageObserver movingAverageObserver = new MovingAverageObserver(3);
        weatherdataobservable.addObserver(movingAverageObserver);
        assertEquals(2, weatherdataobservable.countObservers());
        assertTrue(weatherdataobservable.getWeatherObservers().contains(movingAverageObserver));
        ExponentialSmoothingObserver exponentialSmoothingObserver = new ExponentialSmoothingObserver(0.5);
        weatherdataobservable.addObserver(exponentialSmoothingObserver);
        assertEquals(3, weatherdataobservable.countObservers());
        assertTrue(weatherdataobservable.getWeatherObservers().contains(exponentialSmoothingObserver));

        weatherdataobservable.removeObserver(linearRegressionObserver);
        assertEquals(2, weatherdataobservable.countObservers());
        assertFalse(weatherdataobservable.getWeatherObservers().contains(linearRegressionObserver));
        weatherdataobservable.removeObserver(exponentialSmoothingObserver);
        assertEquals(1, weatherdataobservable.countObservers());
        assertFalse(weatherdataobservable.getWeatherObservers().contains(exponentialSmoothingObserver));
        weatherdataobservable.removeObserver(movingAverageObserver);
        assertEquals(0, weatherdataobservable.countObservers());
        assertFalse(weatherdataobservable.getWeatherObservers().contains(movingAverageObserver));
    }

    @Test
    public void clear_Observers_Test(){
        weatherDataObservable weatherdataobservable = new weatherDataObservable();
        assertEquals(0, weatherdataobservable.countObservers());
        LinearRegressionObserver linearRegressionObserver = new LinearRegressionObserver();
        weatherdataobservable.addObserver(linearRegressionObserver);
        assertEquals(1, weatherdataobservable.countObservers());
        assertTrue(weatherdataobservable.getWeatherObservers().contains(linearRegressionObserver));
        MovingAverageObserver movingAverageObserver = new MovingAverageObserver(3);
        weatherdataobservable.addObserver(movingAverageObserver);
        assertEquals(2, weatherdataobservable.countObservers());
        assertTrue(weatherdataobservable.getWeatherObservers().contains(movingAverageObserver));
        ExponentialSmoothingObserver exponentialSmoothingObserver = new ExponentialSmoothingObserver(0.5);
        weatherdataobservable.addObserver(exponentialSmoothingObserver);
        assertEquals(3, weatherdataobservable.countObservers());
        assertTrue(weatherdataobservable.getWeatherObservers().contains(exponentialSmoothingObserver));
        weatherdataobservable.clearObservers();
        assertFalse(weatherdataobservable.getWeatherObservers().containsAll(List.of(linearRegressionObserver, movingAverageObserver, exponentialSmoothingObserver)));
    }
    @Test
    public void get_Observers_Test(){
        weatherDataObservable weatherdataobservable = new weatherDataObservable();
        assertEquals(0, weatherdataobservable.countObservers());
        LinearRegressionObserver linearRegressionObserver = new LinearRegressionObserver();
        weatherdataobservable.addObserver(linearRegressionObserver);
        assertEquals(1, weatherdataobservable.countObservers());
        assertTrue(weatherdataobservable.getWeatherObservers().contains(linearRegressionObserver));
        MovingAverageObserver movingAverageObserver = new MovingAverageObserver(3);
        weatherdataobservable.addObserver(movingAverageObserver);
        assertEquals(2, weatherdataobservable.countObservers());
        assertTrue(weatherdataobservable.getWeatherObservers().contains(movingAverageObserver));
        ExponentialSmoothingObserver exponentialSmoothingObserver = new ExponentialSmoothingObserver(0.5);
        weatherdataobservable.addObserver(exponentialSmoothingObserver);
        assertEquals(3, weatherdataobservable.countObservers());
        assertTrue(weatherdataobservable.getWeatherObservers().contains(exponentialSmoothingObserver));
        assertIterableEquals(List.of(linearRegressionObserver, movingAverageObserver, exponentialSmoothingObserver), weatherdataobservable.getWeatherObservers());
    }
}