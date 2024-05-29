package umbcs680.Car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriceComparatorTest {
    private static Car car1;
    private static Car car2;
    private static Car car3;
    private static Car car4;

    @BeforeAll
    public static void setUp(){
        car1 = new Car("Subaru", "Outback", 20000, 2020, 28000);
        car2 = new Car("Mazda", "CX-5", 18000, 2019, 25000);
        car3 = new Car("Hyundai", "Sonata", 30000, 2018, 20000);
        car4 = new Car("Kia", "Optima", 22000, 2017, 18000);
    }
    @Test
    public void price_Comparator(){
        List<Car> usedCars = new LinkedList<>(List.of(car1, car2, car3, car4));
        Collections.sort(usedCars, new PriceComparator());
        assertIterableEquals(List.of(car1, car2, car3, car4), usedCars);
    }

}