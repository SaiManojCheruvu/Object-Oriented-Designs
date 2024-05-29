package umbcs680.multicast;

import java.util.List;

public class MovingAverageObserver implements stockObserver, weatherObserver{
    private double forecast;
    private int windowSize;
    public MovingAverageObserver(int windowSize){
        this.windowSize = windowSize;
    }
    @Override
    public void updateStockData(stockEvent stockEvent) {
        double forecast;
        List<Double> data = stockEvent.getStockList();
        int dataSize = data.size();
        if (dataSize < windowSize)
            forecast = 0;
        double sum = 0;
        for (int i = dataSize - windowSize; i < dataSize; i++) {
            sum += data.get(i);
        }
        forecast = sum / windowSize;
        this.forecast = forecast;
        System.out.println("The forecasted value using Moving Average for given stock data is "+forecast);
    }

    @Override
    public void updateWeatherData(weatherEvent weatherEvent) {
        double forecast;
        List<Double> data = weatherEvent.getWeatherList();
        int dataSize = data.size();
        if (dataSize < windowSize)
            forecast = 0;
        double sum = 0;
        for (int i = dataSize - windowSize; i < dataSize; i++) {
            sum += data.get(i);
        }
        forecast = sum / windowSize;
        this.forecast = forecast;
        System.out.println("The forecasted value using Moving Average for given weather data is "+forecast);
    }

    public double getForecast() {
        return forecast;
    }
}
