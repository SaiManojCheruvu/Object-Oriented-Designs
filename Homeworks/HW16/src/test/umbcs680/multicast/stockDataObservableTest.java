package umbcs680.multicast;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class stockDataObservableTest {

    // Notify Observer tests
    @Test
    public void exponential_Smoothing_Observer_on_stock_data_Test(){
       stockDataObservable stockdataobservable = new stockDataObservable();
       double[] forecast = new double[1];
        stockdataobservable.addObserver((stockEvent -> {
            double alpha = 0.5;
            List<Double> data = stockEvent.getStockList();
            double lastValue = data.get(data.size() - 1);
            double smoothedValue = lastValue;
            for (int i = data.size() - 2; i >= 0; i--) {
                double currentValue = data.get(i);
                smoothedValue = alpha * currentValue + (1 - alpha) * smoothedValue;
            }
            forecast[0] = smoothedValue;
            System.out.println("Forecast value using Exponential Smoothing for given stock data is "+smoothedValue);
        }));
        stockdataobservable.notifyObservers(new stockEvent(List.of(10.0, 12.0, 14.0, 11.0)));
        assertEquals(11.125, forecast[0]);
    }
    @Test
    public void linear_Regression_Observer_on_stock_Data_Test(){
        stockDataObservable stockdataobservable = new stockDataObservable();
        double[] forecasted = new double[1];
        stockdataobservable.addObserver(stockEvent -> {
            List<Double> data = stockEvent.getStockList();
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
            System.out.println("The forecasted value using Linear Regression for given stock data is "+forecast);
        });
        stockdataobservable.notifyObservers(new stockEvent(List.of(10.0, 12.0, 14.0, 11.0)));
        assertEquals(13.0, forecasted[0]);
    }
    @Test
    public void moving_Average_Observer_on_stock_Data_Test(){
        stockDataObservable stockdataobservable = new stockDataObservable();
        double[] forecasted = new double[1];
        stockdataobservable.addObserver(stockEvent -> {
            double forecast;
            int windowSize = 3;
            List<Double> data = stockEvent.getStockList();
            int dataSize = data.size();
            if (dataSize < windowSize)
                forecast = 0;
            double sum = 0;
            for (int i = dataSize - windowSize; i < dataSize; i++) {
                sum += data.get(i);
            }
            forecast = sum / windowSize;
            forecasted[0] = forecast;
            System.out.println("The forecasted value using Moving Average for given stock data is "+forecast);
        });
        stockdataobservable.notifyObservers(new stockEvent(List.of(10.0, 12.0, 14.0, 11.0 )));
        assertEquals(12.333333333333334, forecasted[0]);
    }

    //Tests for other public methods
    @Test
    public void add_Observer_Test(){
        stockDataObservable stockdataobservable = new stockDataObservable();
        assertEquals(0, stockdataobservable.countObservers());
        stockdataobservable.addObserver((stockEvent -> {
            double alpha = 0.5;
            List<Double> data = stockEvent.getStockList();
            double lastValue = data.get(data.size() - 1);
            double smoothedValue = lastValue;
            for (int i = data.size() - 2; i >= 0; i--) {
                double currentValue = data.get(i);
                smoothedValue = alpha * currentValue + (1 - alpha) * smoothedValue;
            }
            System.out.println("Forecast value using Exponential Smoothing for given stock data is "+smoothedValue);
        }));
        assertEquals(1, stockdataobservable.countObservers());
        stockdataobservable.addObserver(stockEvent -> {
            List<Double> data = stockEvent.getStockList();
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
            System.out.println("The forecasted value using Linear Regression for given stock data is "+forecast);
        });
        assertEquals(2, stockdataobservable.countObservers());
        stockdataobservable.addObserver(stockEvent -> {
            double forecast;
            int windowSize = 3;
            List<Double> data = stockEvent.getStockList();
            int dataSize = data.size();
            if (dataSize < windowSize)
                forecast = 0;
            double sum = 0;
            for (int i = dataSize - windowSize; i < dataSize; i++) {
                sum += data.get(i);
            }
            forecast = sum / windowSize;
            System.out.println("The forecasted value using Moving Average for given stock data is "+forecast);
        });
        assertEquals(3, stockdataobservable.countObservers());
    }
    @Test
    public void remove_Observer_Test(){
        stockDataObservable stockdataobservable = new stockDataObservable();
        assertEquals(0, stockdataobservable.countObservers());

        stockdataobservable.addObserver(stockEvent -> {
            double alpha = 0.5;
            List<Double> data = stockEvent.getStockList();
            double lastValue = data.get(data.size() - 1);
            double smoothedValue = lastValue;
            for (int i = data.size() - 2; i >= 0; i--) {
                double currentValue = data.get(i);
                smoothedValue = alpha * currentValue + (1 - alpha) * smoothedValue;
            }
            System.out.println("Forecast value using Exponential Smoothing for given stock data is "+smoothedValue);
        });

        assertEquals(1, stockdataobservable.countObservers());
        stockdataobservable.addObserver(stockEvent -> {
            List<Double> data = stockEvent.getStockList();
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
            System.out.println("The forecasted value using Linear Regression for given stock data is "+forecast);
        });

        assertEquals(2, stockdataobservable.countObservers());

        stockdataobservable.addObserver(stockEvent -> {
            double forecast;
            int windowSize = 3;
            List<Double> data = stockEvent.getStockList();
            int dataSize = data.size();
            if (dataSize < windowSize)
                forecast = 0;
            double sum = 0;
            for (int i = dataSize - windowSize; i < dataSize; i++) {
                sum += data.get(i);
            }
            forecast = sum / windowSize;
            System.out.println("The forecasted value using Moving Average for given stock data is "+forecast);
        });

        assertEquals(3, stockdataobservable.countObservers());
        List<stockObserver> observers = stockdataobservable.getStockObservers();
        stockdataobservable.removerObserver(observers.get(0));
        assertEquals(2, stockdataobservable.countObservers());
        stockdataobservable.removerObserver(observers.get(0));
        assertEquals(1, stockdataobservable.countObservers());
        stockdataobservable.removerObserver(observers.get(0));
        assertEquals(0, stockdataobservable.countObservers());
        List<stockObserver> observersAfterRemoval = stockdataobservable.getStockObservers();
        assertIterableEquals(List.of(), observersAfterRemoval);


    }

    @Test
    public void get_Observers_Test(){
        stockDataObservable stockdataobservable = new stockDataObservable();
        assertEquals(0, stockdataobservable.countObservers());
        stockdataobservable.addObserver(stockEvent -> {
            double alpha = 0.5;
            List<Double> data = stockEvent.getStockList();
            double lastValue = data.get(data.size() - 1);
            double smoothedValue = lastValue;
            for (int i = data.size() - 2; i >= 0; i--) {
                double currentValue = data.get(i);
                smoothedValue = alpha * currentValue + (1 - alpha) * smoothedValue;
            }
            System.out.println("Forecast value using Exponential Smoothing for given stock data is "+smoothedValue);
        });
        assertEquals(1, stockdataobservable.countObservers());
        stockdataobservable.addObserver(stockEvent -> {
            List<Double> data = stockEvent.getStockList();
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
            System.out.println("The forecasted value using Linear Regression for given stock data is "+forecast);});
        assertEquals(2, stockdataobservable.countObservers());
        stockdataobservable.addObserver(stockEvent -> {
            double forecast;
            int windowSize = 3;
            List<Double> data = stockEvent.getStockList();
            int dataSize = data.size();
            if (dataSize < windowSize)
                forecast = 0;
            double sum = 0;
            for (int i = dataSize - windowSize; i < dataSize; i++) {
                sum += data.get(i);
            }
            forecast = sum / windowSize;
            System.out.println("The forecasted value using Moving Average for given stock data is "+forecast);});
        assertEquals(3, stockdataobservable.getStockObservers().size());

    }
    @Test
    public void clear_Observers_Test(){
        stockDataObservable stockdataobservable = new stockDataObservable();
        assertEquals(0, stockdataobservable.countObservers());
        stockdataobservable.addObserver((stockEvent -> {
            double alpha = 0.5;
            List<Double> data = stockEvent.getStockList();
            double lastValue = data.get(data.size() - 1);
            double smoothedValue = lastValue;
            for (int i = data.size() - 2; i >= 0; i--) {
                double currentValue = data.get(i);
                smoothedValue = alpha * currentValue + (1 - alpha) * smoothedValue;
            }
            System.out.println("Forecast value using Exponential Smoothing for given stock data is "+smoothedValue);
        }));
        assertEquals(1, stockdataobservable.countObservers());
        stockdataobservable.addObserver(stockEvent -> {
            List<Double> data = stockEvent.getStockList();
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
            System.out.println("The forecasted value using Linear Regression for given stock data is "+forecast);
        });
        assertEquals(2, stockdataobservable.countObservers());
        stockdataobservable.addObserver(stockEvent -> {
            double forecast;
            int windowSize = 3;
            List<Double> data = stockEvent.getStockList();
            int dataSize = data.size();
            if (dataSize < windowSize)
                forecast = 0;
            double sum = 0;
            for (int i = dataSize - windowSize; i < dataSize; i++) {
                sum += data.get(i);
            }
            forecast = sum / windowSize;
            System.out.println("The forecasted value using Moving Average for given stock data is "+forecast);
        });
        assertEquals(3, stockdataobservable.countObservers());

        stockdataobservable.clearObservers();
        assertEquals(0, stockdataobservable.countObservers());
    }
}