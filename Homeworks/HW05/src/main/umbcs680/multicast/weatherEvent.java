package umbcs680.multicast;
import java.util.List;

public class weatherEvent {
    private List<Double> weatherList;
    public weatherEvent(List<Double> weatherList){
        this.weatherList = weatherList;
    }

    public List<Double> getWeatherList() {
        return weatherList;
    }
}
