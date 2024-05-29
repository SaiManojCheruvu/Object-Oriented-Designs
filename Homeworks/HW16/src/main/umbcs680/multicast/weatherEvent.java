package umbcs680.multicast;
import java.util.List;

public class weatherEvent {
    private static List<Double> weatherList;
    public weatherEvent(List<Double> weatherList){
        this.weatherList = weatherList;
    }

    public static List<Double> getWeatherList() {
        return weatherList;
    }
}
