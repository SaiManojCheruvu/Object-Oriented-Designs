package umbcs680.multicast;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class stockDataObservableTest {

    // Notify Observer tests
    @Test
    public void exponential_Smoothing_Observer_on_stock_data_Test(){
       stockDataObservable stockdataobservable = new stockDataObservable();
       ExponentialSmoothingObserver exponentialSmoothingObserver = new ExponentialSmoothingObserver(0.5);
        stockdataobservable.addObserver(exponentialSmoothingObserver);
        stockdataobservable.notifyObservers(new stockEvent(List.of(10.0, 12.0, 14.0, 11.0)));
        assertEquals(11.125, exponentialSmoothingObserver.getForecast());
    }
    @Test
    public void linear_Regression_Observer_on_stock_Data_Test(){
        stockDataObservable stockdataobservable = new stockDataObservable();
        LinearRegressionObserver linearRegressionObserver = new LinearRegressionObserver();
        stockdataobservable.addObserver(linearRegressionObserver);
        stockdataobservable.notifyObservers(new stockEvent(List.of(10.0, 12.0, 14.0, 11.0)));
        assertEquals(13.0, linearRegressionObserver.getForecast());
    }
    @Test
    public void moving_Average_Observer_on_stock_Data_Test(){
        stockDataObservable stockdataobservable = new stockDataObservable();
        MovingAverageObserver movingAverageObserver = new MovingAverageObserver(3);
        stockdataobservable.addObserver(movingAverageObserver);
        stockdataobservable.notifyObservers(new stockEvent(List.of(10.0, 12.0, 14.0, 11.0 )));
        assertEquals(12.333333333333334, movingAverageObserver.getForecast());
    }

    //Tests for other public methods
    @Test
    public void add_Observer_Test(){
        stockDataObservable stockdataobservable = new stockDataObservable();
        assertEquals(0, stockdataobservable.countObservers());
        ExponentialSmoothingObserver exponentialSmoothingObserver = new ExponentialSmoothingObserver(0.5);
        stockdataobservable.addObserver(exponentialSmoothingObserver);
        assertEquals(1, stockdataobservable.countObservers());
        LinearRegressionObserver linearRegressionObserver = new LinearRegressionObserver();
        stockdataobservable.addObserver(linearRegressionObserver);
        assertEquals(2, stockdataobservable.countObservers());
        MovingAverageObserver movingAverageObserver = new MovingAverageObserver(3);
        stockdataobservable.addObserver(movingAverageObserver);
        assertEquals(3, stockdataobservable.countObservers());
        assertTrue(stockdataobservable.getStockObservers().contains(linearRegressionObserver));
        assertTrue(stockdataobservable.getStockObservers().contains(movingAverageObserver));
        assertTrue(stockdataobservable.getStockObservers().contains(exponentialSmoothingObserver));
    }
    @Test
    public void remove_Observer_Test(){
        stockDataObservable stockdataobservable = new stockDataObservable();
        assertEquals(0, stockdataobservable.countObservers());
        ExponentialSmoothingObserver exponentialSmoothingObserver = new ExponentialSmoothingObserver(0.5);
        stockdataobservable.addObserver(exponentialSmoothingObserver);
        assertEquals(1, stockdataobservable.countObservers());
        LinearRegressionObserver linearRegressionObserver = new LinearRegressionObserver();
        stockdataobservable.addObserver(linearRegressionObserver);
        assertEquals(2, stockdataobservable.countObservers());
        MovingAverageObserver movingAverageObserver = new MovingAverageObserver(3);
        stockdataobservable.addObserver(movingAverageObserver);
        assertEquals(3, stockdataobservable.countObservers());
        assertTrue(stockdataobservable.getStockObservers().contains(linearRegressionObserver));
        assertTrue(stockdataobservable.getStockObservers().contains(movingAverageObserver));
        assertTrue(stockdataobservable.getStockObservers().contains(exponentialSmoothingObserver));

        stockdataobservable.removerObserver(exponentialSmoothingObserver);
        assertEquals(2, stockdataobservable.countObservers());
        assertFalse(stockdataobservable.getStockObservers().contains(exponentialSmoothingObserver));
        stockdataobservable.removerObserver(linearRegressionObserver);
        assertEquals(1, stockdataobservable.countObservers());
        assertFalse(stockdataobservable.getStockObservers().contains(linearRegressionObserver));
        stockdataobservable.removerObserver(movingAverageObserver);
        assertEquals(0, stockdataobservable.countObservers());
        assertFalse(stockdataobservable.getStockObservers().contains(movingAverageObserver));
    }
    @Test
    public void get_Observers_Test(){
        stockDataObservable stockdataobservable = new stockDataObservable();
        assertEquals(0, stockdataobservable.countObservers());
        ExponentialSmoothingObserver exponentialSmoothingObserver = new ExponentialSmoothingObserver(0.5);
        stockdataobservable.addObserver(exponentialSmoothingObserver);
        assertEquals(1, stockdataobservable.countObservers());
        LinearRegressionObserver linearRegressionObserver = new LinearRegressionObserver();
        stockdataobservable.addObserver(linearRegressionObserver);
        assertEquals(2, stockdataobservable.countObservers());
        MovingAverageObserver movingAverageObserver = new MovingAverageObserver(3);
        stockdataobservable.addObserver(movingAverageObserver);
        assertEquals(3, stockdataobservable.countObservers());
        assertTrue(stockdataobservable.getStockObservers().contains(linearRegressionObserver));
        assertTrue(stockdataobservable.getStockObservers().contains(movingAverageObserver));
        assertTrue(stockdataobservable.getStockObservers().contains(exponentialSmoothingObserver));

        assertIterableEquals(List.of(exponentialSmoothingObserver, linearRegressionObserver, movingAverageObserver), stockdataobservable.getStockObservers());
    }
    @Test
    public void clear_Observers_Test(){
        stockDataObservable stockdataobservable = new stockDataObservable();
        assertEquals(0, stockdataobservable.countObservers());
        ExponentialSmoothingObserver exponentialSmoothingObserver = new ExponentialSmoothingObserver(0.5);
        stockdataobservable.addObserver(exponentialSmoothingObserver);
        assertEquals(1, stockdataobservable.countObservers());
        LinearRegressionObserver linearRegressionObserver = new LinearRegressionObserver();
        stockdataobservable.addObserver(linearRegressionObserver);
        assertEquals(2, stockdataobservable.countObservers());
        MovingAverageObserver movingAverageObserver = new MovingAverageObserver(3);
        stockdataobservable.addObserver(movingAverageObserver);
        assertEquals(3, stockdataobservable.countObservers());
        assertTrue(stockdataobservable.getStockObservers().contains(linearRegressionObserver));
        assertTrue(stockdataobservable.getStockObservers().contains(movingAverageObserver));
        assertTrue(stockdataobservable.getStockObservers().contains(exponentialSmoothingObserver));

        stockdataobservable.clearObservers();
        assertFalse(stockdataobservable.getStockObservers().containsAll(List.of(linearRegressionObserver, movingAverageObserver, exponentialSmoothingObserver)));
    }


}