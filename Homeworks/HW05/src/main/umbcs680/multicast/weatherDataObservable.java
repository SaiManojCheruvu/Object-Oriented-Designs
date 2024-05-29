package umbcs680.multicast;

import java.util.LinkedList;
import java.util.List;

public class weatherDataObservable {
    List<weatherObserver> weatherObservers;
    public weatherDataObservable(){
        this.weatherObservers = new LinkedList<>();
    }
    public void addObserver(weatherObserver weatherObserver){
        weatherObservers.add(weatherObserver);
    }
    public void removeObserver(weatherObserver weatherObserver){
        weatherObservers.remove(weatherObserver);
    }
    public int countObservers(){
        return weatherObservers.size();
    }
    public void clearObservers(){
        weatherObservers.clear();
    }
    public List<weatherObserver> getWeatherObservers(){
        return weatherObservers;
    }
    public void notifyObservers(weatherEvent weatherEvent){
        weatherObservers.forEach(observer->observer.updateWeatherData(weatherEvent));
    }
}
