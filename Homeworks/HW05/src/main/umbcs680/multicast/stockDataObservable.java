package umbcs680.multicast;

import java.util.LinkedList;
import java.util.List;

public class stockDataObservable {
    List<stockObserver> stockObservers;
    public stockDataObservable(){
        this.stockObservers = new LinkedList<>();
    }
    public void addObserver(stockObserver stockObserver){
        stockObservers.add(stockObserver);
    }
    public void removerObserver(stockObserver stockObserver){
        stockObservers.remove(stockObserver);
    }
    public int countObservers(){
        return stockObservers.size();
    }
    public List<stockObserver> getStockObservers(){
        return stockObservers;
    }
    public void clearObservers(){
        stockObservers.clear();
    }
    public void notifyObservers(stockEvent stockEvent){
        stockObservers.forEach(observer->observer.updateStockData(stockEvent));
    }

}
