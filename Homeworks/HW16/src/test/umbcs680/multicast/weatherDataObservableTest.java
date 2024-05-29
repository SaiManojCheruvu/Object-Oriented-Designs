package umbcs680.multicast;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class weatherDataObservableTest {
    //Notify Observers Tests
    @Test
    public void exponential_Smoothing_Observer_On_Weather_Data_Test(){
        weatherDataObservable weatherdataobservable = new weatherDataObservable();
        double[] forecast = new double[1];
        weatherdataobservable.addObserver((weatherEvent event)-> {
            double alpha = 0.5;
            List<Double> data = weatherEvent.getWeatherList();
            double lastValue = data.get(data.size() - 1);
            double smoothedValue = lastValue;
            for (int i = data.size() - 2; i >= 0; i--) {
                double currentValue = data.get(i);
                smoothedValue = alpha * currentValue + (1 - alpha) * smoothedValue;
            }
            forecast[0] = smoothedValue;
            System.out.println("Forecast value using Exponential Smoothing for given weather data is "+smoothedValue);
        });
        weatherdataobservable.notifyObservers(new weatherEvent(List.of(25.0, 30.0, 35.0, 40.0)));
        assertEquals(29.375, forecast[0]);
    }
    @Test
    public void moving_Average_Observer_On_Weather_Data_Test(){
        weatherDataObservable weatherdataobservable = new weatherDataObservable();
        double[] forecasted = new double[1];
        weatherdataobservable.addObserver(weatherEvent -> {
            int windowSize = 3;
            double forecast = 0;
            List<Double> data = weatherEvent.getWeatherList();
            int dataSize = data.size();
            if (dataSize < windowSize)
                forecast = 0;
            double sum = 0;
            for (int i = dataSize - windowSize; i < dataSize; i++) {
                sum += data.get(i);
            }
            forecast = sum / windowSize;
            forecasted[0] = forecast;
            System.out.println("The forecasted value using Moving Average for given weather data is "+forecast);
        });
        weatherdataobservable.notifyObservers(new weatherEvent(List.of(25.0, 30.0, 35.0, 40.0)));
        assertEquals(35.0, forecasted[0]);
    }
    @Test
    public void linear_Regression_Observer_On_Weather_Data_Test(){
        weatherDataObservable weatherdataobservable = new weatherDataObservable();
        double[] forecasted = new double[1];
        weatherdataobservable.addObserver(weatherEvent -> {
            List<Double> data = weatherEvent.getWeatherList();
            int n = data.size();
            double sumX = 0, sumY = 0, sumXY = 0, sumXSquare = 0;

            for (int i = 0; i < n; i++) {
                double x = i + 1;
                double y = data.get(i);
                sumX += x;
                sumY += y;
                sumXY += x * y;
                sumXSquare += x * x;
            }
            double meanX = sumX / n;
            double meanY = sumY / n;
            double slope = (n * sumXY - sumX * sumY) / (n * sumXSquare - sumX * sumX);
            double intercept = meanY - slope * meanX;
            double nextX = n + 1;
            double forecast = slope * nextX + intercept;
            forecasted[0] = forecast;
            System.out.println("The forecasted value using Linear Regression for given weather data is "+forecast);
        });
        weatherdataobservable.notifyObservers(new weatherEvent(List.of(25.0, 30.0, 35.0, 40.0)));
        assertEquals(45.0, forecasted[0]);
    }

    //Test cases for other public methods

    @Test
    public void add_Observer_Test(){
        weatherDataObservable weatherdataobservable = new weatherDataObservable();
        assertEquals(0, weatherdataobservable.countObservers());
        weatherdataobservable.addObserver(weatherEvent -> {
            List<Double> data = weatherEvent.getWeatherList();
            int n = data.size();
            double sumX = 0, sumY = 0, sumXY = 0, sumXSquare = 0;

            for (int i = 0; i < n; i++) {
                double x = i + 1;
                double y = data.get(i);
                sumX += x;
                sumY += y;
                sumXY += x * y;
                sumXSquare += x * x;
            }
            double meanX = sumX / n;
            double meanY = sumY / n;
            double slope = (n * sumXY - sumX * sumY) / (n * sumXSquare - sumX * sumX);
            double intercept = meanY - slope * meanX;
            double nextX = n + 1;
            double forecast = slope * nextX + intercept;
            System.out.println("The forecasted value using Linear Regression for given weather data is "+forecast);
        });
        assertEquals(1, weatherdataobservable.countObservers());
        weatherdataobservable.addObserver(weatherEvent -> {
            int windowSize = 3;
            double forecast = 0;
            List<Double> data = weatherEvent.getWeatherList();
            int dataSize = data.size();
            if (dataSize < windowSize)
                forecast = 0;
            double sum = 0;
            for (int i = dataSize - windowSize; i < dataSize; i++) {
                sum += data.get(i);
            }
            forecast = sum / windowSize;
            System.out.println("The forecasted value using Moving Average for given weather data is "+forecast);
        });
        assertEquals(2, weatherdataobservable.countObservers());
        weatherdataobservable.addObserver((weatherEvent event)-> {
            double alpha = 0.5;
            List<Double> data = weatherEvent.getWeatherList();
            double lastValue = data.get(data.size() - 1);
            double smoothedValue = lastValue;
            for (int i = data.size() - 2; i >= 0; i--) {
                double currentValue = data.get(i);
                smoothedValue = alpha * currentValue + (1 - alpha) * smoothedValue;
            }
            System.out.println("Forecast value using Exponential Smoothing for given weather data is "+smoothedValue);
        });
        assertEquals(3, weatherdataobservable.countObservers());
    }

    @Test
    public void remove_Observer_Test(){
        weatherDataObservable weatherdataobservable = new weatherDataObservable();
        assertEquals(0, weatherdataobservable.countObservers());
        weatherdataobservable.addObserver(weatherEvent -> {
            List<Double> data = weatherEvent.getWeatherList();
            int n = data.size();
            double sumX = 0, sumY = 0, sumXY = 0, sumXSquare = 0;

            for (int i = 0; i < n; i++) {
                double x = i + 1;
                double y = data.get(i);
                sumX += x;
                sumY += y;
                sumXY += x * y;
                sumXSquare += x * x;
            }
            double meanX = sumX / n;
            double meanY = sumY / n;
            double slope = (n * sumXY - sumX * sumY) / (n * sumXSquare - sumX * sumX);
            double intercept = meanY - slope * meanX;
            double nextX = n + 1;
            double forecast = slope * nextX + intercept;
            System.out.println("The forecasted value using Linear Regression for given weather data is "+forecast);
        });
        assertEquals(1, weatherdataobservable.countObservers());
        weatherdataobservable.addObserver(weatherEvent -> {
            int windowSize = 3;
            double forecast = 0;
            List<Double> data = weatherEvent.getWeatherList();
            int dataSize = data.size();
            if (dataSize < windowSize)
                forecast = 0;
            double sum = 0;
            for (int i = dataSize - windowSize; i < dataSize; i++) {
                sum += data.get(i);
            }
            forecast = sum / windowSize;
            System.out.println("The forecasted value using Moving Average for given weather data is "+forecast);
        });
        assertEquals(2, weatherdataobservable.countObservers());
        weatherdataobservable.addObserver((weatherEvent event)-> {
            double alpha = 0.5;
            List<Double> data = weatherEvent.getWeatherList();
            double lastValue = data.get(data.size() - 1);
            double smoothedValue = lastValue;
            for (int i = data.size() - 2; i >= 0; i--) {
                double currentValue = data.get(i);
                smoothedValue = alpha * currentValue + (1 - alpha) * smoothedValue;
            }
            System.out.println("Forecast value using Exponential Smoothing for given weather data is "+smoothedValue);
        });
        assertEquals(3, weatherdataobservable.countObservers());

        List<weatherObserver> observers = weatherdataobservable.getWeatherObservers();
        weatherdataobservable.removeObserver(observers.get(0));
        assertEquals(2, weatherdataobservable.countObservers());
        weatherdataobservable.removeObserver(observers.get(0));
        assertEquals(1, weatherdataobservable.countObservers());
        weatherdataobservable.removeObserver(observers.get(0));
        assertEquals(0, weatherdataobservable.countObservers());
        assertIterableEquals(List.of(), weatherdataobservable.getWeatherObservers());
    }

    @Test
    public void clear_Observers_Test(){
        weatherDataObservable weatherdataobservable = new weatherDataObservable();
        assertEquals(0, weatherdataobservable.countObservers());
        weatherdataobservable.addObserver(weatherEvent -> {
            List<Double> data = weatherEvent.getWeatherList();
            int n = data.size();
            double sumX = 0, sumY = 0, sumXY = 0, sumXSquare = 0;

            for (int i = 0; i < n; i++) {
                double x = i + 1;
                double y = data.get(i);
                sumX += x;
                sumY += y;
                sumXY += x * y;
                sumXSquare += x * x;
            }
            double meanX = sumX / n;
            double meanY = sumY / n;
            double slope = (n * sumXY - sumX * sumY) / (n * sumXSquare - sumX * sumX);
            double intercept = meanY - slope * meanX;
            double nextX = n + 1;
            double forecast = slope * nextX + intercept;
            System.out.println("The forecasted value using Linear Regression for given weather data is "+forecast);
        });
        assertEquals(1, weatherdataobservable.countObservers());
        weatherdataobservable.addObserver(weatherEvent -> {
            int windowSize = 3;
            double forecast = 0;
            List<Double> data = weatherEvent.getWeatherList();
            int dataSize = data.size();
            if (dataSize < windowSize)
                forecast = 0;
            double sum = 0;
            for (int i = dataSize - windowSize; i < dataSize; i++) {
                sum += data.get(i);
            }
            forecast = sum / windowSize;
            System.out.println("The forecasted value using Moving Average for given weather data is "+forecast);
        });
        assertEquals(2, weatherdataobservable.countObservers());
        weatherdataobservable.addObserver((weatherEvent event)-> {
            double alpha = 0.5;
            List<Double> data = weatherEvent.getWeatherList();
            double lastValue = data.get(data.size() - 1);
            double smoothedValue = lastValue;
            for (int i = data.size() - 2; i >= 0; i--) {
                double currentValue = data.get(i);
                smoothedValue = alpha * currentValue + (1 - alpha) * smoothedValue;
            }
            System.out.println("Forecast value using Exponential Smoothing for given weather data is "+smoothedValue);
        });
        assertEquals(3, weatherdataobservable.countObservers());
        weatherdataobservable.clearObservers();
        assertEquals(0, weatherdataobservable.countObservers());


    }
    @Test
    public void get_Observers_Test(){
        weatherDataObservable weatherdataobservable = new weatherDataObservable();
        assertEquals(0, weatherdataobservable.countObservers());
        weatherdataobservable.addObserver(weatherEvent -> {
            List<Double> data = weatherEvent.getWeatherList();
            int n = data.size();
            double sumX = 0, sumY = 0, sumXY = 0, sumXSquare = 0;

            for (int i = 0; i < n; i++) {
                double x = i + 1;
                double y = data.get(i);
                sumX += x;
                sumY += y;
                sumXY += x * y;
                sumXSquare += x * x;
            }
            double meanX = sumX / n;
            double meanY = sumY / n;
            double slope = (n * sumXY - sumX * sumY) / (n * sumXSquare - sumX * sumX);
            double intercept = meanY - slope * meanX;
            double nextX = n + 1;
            double forecast = slope * nextX + intercept;
            System.out.println("The forecasted value using Linear Regression for given weather data is "+forecast);
        });
        assertEquals(1, weatherdataobservable.countObservers());
        weatherdataobservable.addObserver(weatherEvent -> {
            int windowSize = 3;
            double forecast = 0;
            List<Double> data = weatherEvent.getWeatherList();
            int dataSize = data.size();
            if (dataSize < windowSize)
                forecast = 0;
            double sum = 0;
            for (int i = dataSize - windowSize; i < dataSize; i++) {
                sum += data.get(i);
            }
            forecast = sum / windowSize;
            System.out.println("The forecasted value using Moving Average for given weather data is "+forecast);
        });
        assertEquals(2, weatherdataobservable.countObservers());
        weatherdataobservable.addObserver((weatherEvent event)-> {
            double alpha = 0.5;
            List<Double> data = weatherEvent.getWeatherList();
            double lastValue = data.get(data.size() - 1);
            double smoothedValue = lastValue;
            for (int i = data.size() - 2; i >= 0; i--) {
                double currentValue = data.get(i);
                smoothedValue = alpha * currentValue + (1 - alpha) * smoothedValue;
            }
            System.out.println("Forecast value using Exponential Smoothing for given weather data is "+smoothedValue);
        });
        assertEquals(3, weatherdataobservable.getWeatherObservers().size());
    }
}