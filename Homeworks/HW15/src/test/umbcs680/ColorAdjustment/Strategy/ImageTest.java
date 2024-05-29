package umbcs680.ColorAdjustment.Strategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ImageTest {
    @Test
    void testGetHeightAndWidth() {
        Image image = new Image(5, 10);
        assertEquals(5, image.getHeight());
        assertEquals(10, image.getWidth());
    }
    @Test
    void testSetColorAndGetColor() {
        Image image = new Image(3, 3);
        Color color = new Color(100, 150, 200);
        image.setColor(1, 1, color);
        assertEquals(color, image.getColor(1, 1));
    }
}
