package umbcs680.Car;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return (int) (o2.getPrice() - o1.getPrice());
    }
}
