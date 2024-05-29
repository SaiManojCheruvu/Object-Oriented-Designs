package umbcs680.multicast;

import java.util.List;

public class ExponentialSmoothingObserver implements stockObserver, weatherObserver{
    private double alpha;
    private double forecast;
    public ExponentialSmoothingObserver(double alpha){
        this.alpha = alpha;
    }
    @Override
    public void updateStockData(stockEvent stockEvent) {
        List<Double> data = stockEvent.getStockList();
        double lastValue = data.get(data.size() - 1);
        double smoothedValue = lastValue;
        for (int i = data.size() - 2; i >= 0; i--) {
            double currentValue = data.get(i);
            smoothedValue = alpha * currentValue + (1 - alpha) * smoothedValue;
        }
        this.forecast = smoothedValue;
        System.out.println("Forecast value using Exponential Smoothing for given stock data is "+smoothedValue);
    }

    @Override
    public void updateWeatherData(weatherEvent weatherEvent) {
        List<Double> data = weatherEvent.getWeatherList();
        double lastValue = data.get(data.size() - 1);
        double smoothedValue = lastValue;
        for (int i = data.size() - 2; i >= 0; i--) {
            double currentValue = data.get(i);
            smoothedValue = alpha * currentValue + (1 - alpha) * smoothedValue;
        }
        this.forecast = smoothedValue;
        System.out.println("Forecast value using Exponential Smoothing for given weather data is "+smoothedValue);
    }
    public double getForecast(){
        return this.forecast;
    }
}
