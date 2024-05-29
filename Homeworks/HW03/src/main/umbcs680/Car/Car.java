package umbcs680.Car;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;
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
}
