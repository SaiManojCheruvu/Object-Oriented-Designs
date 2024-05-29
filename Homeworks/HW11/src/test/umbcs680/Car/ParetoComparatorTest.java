package umbcs680.Car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParetoComparatorTest {
    private static Car car1;
    private static Car car2;
    private static Car car3;
    private static Car car4;
    @BeforeAll
    public static void setUp(){
        car1 = new Car("Toyota", "Camry", 50000, 2018, 20000);
        car2 = new Car("Honda", "Civic", 30000, 2019, 18000);
        car3 = new Car("Ford", "Fusion", 40000, 2017, 15000);
        car4 = new Car("Chevrolet", "Malibu", 20000, 2020, 22000);
    }
    @Test
    public void Pareto_Comparator(){
        LinkedList<Car> usedCars = new LinkedList<>(List.of(car1, car2, car3, car4));
        car1.setDominationCount(usedCars);
        car2.setDominationCount(usedCars);
        car3.setDominationCount(usedCars);
        car4.setDominationCount(usedCars);
        Collections.sort(usedCars, new ParetoComparator());
        for(Car c: usedCars){
            System.out.println(c.getMake()+c.getDominationCount());
        }
        assertIterableEquals(List.of(car2, car1, car3, car4), usedCars);
    }


}