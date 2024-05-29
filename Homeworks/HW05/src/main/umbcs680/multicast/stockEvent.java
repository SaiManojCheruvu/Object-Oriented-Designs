package umbcs680.multicast;
import java.util.List;
public class stockEvent {
    private List<Double> stockList;
    public stockEvent(List<Double> stockList){
        this.stockList = stockList;
    }

    public List<Double> getStockList() {
        return stockList;
    }
}
