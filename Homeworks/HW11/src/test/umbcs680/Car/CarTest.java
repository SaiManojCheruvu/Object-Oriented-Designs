package umbcs680.Car;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;
class CarTest {
    private String[] carToStringArray(Car c){
        return new String[]{c.getMake(), c.getModel(), String.valueOf(c.getYear())};
    }
    @Test
    public void verifyCarEqualityWithMakeModelYear(){
        String[] expected = {"Volvo", "XL", "2013"};
        Car actual = new Car("Volvo", "XL", 20, 2013, 20000f);
        assertArrayEquals(expected, carToStringArray(actual));
    }

}