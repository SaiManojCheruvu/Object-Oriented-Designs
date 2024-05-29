package umbcs680.multicast;

import java.util.List;

public class LinearRegressionObserver implements stockObserver, weatherObserver {
    private double forecast;

    @Override
    public void updateStockData(stockEvent stockEvent) {
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
        this.forecast = forecast;
        System.out.println("The forecasted value using Linear Regression for given stock data is "+forecast);
    }

    @Override
    public void updateWeatherData(weatherEvent weatherEvent) {
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
        this.forecast = forecast;
        System.out.println("The forecasted value using Linear Regression for given weather data is "+forecast);
    }

    public double getForecast() {
        return forecast;
    }
}
