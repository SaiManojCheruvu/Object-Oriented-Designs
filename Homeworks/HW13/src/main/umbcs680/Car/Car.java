package umbcs680.Car;
import java.util.LinkedList;
public class Car {
    private String make, model;
    private int mileage, year;
    private float price;
    private int dominationCount;
    public Car(String make, String model, int mileage, int year, float price){
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
    public void setDominationCount(LinkedList<Car> usedCars) {
        int count = 0;
        for (Car c : usedCars) {
            if (!c.equals(this) &&
                    c.getYear() <= this.getYear() &&
                    c.getMileage() >= this.getMileage() &&
                    c.getPrice() >= this.getPrice()) {
                count++;
            }
        }
        this.dominationCount = count;
    }

    public int getDominationCount() {
        return dominationCount;
    }
}
