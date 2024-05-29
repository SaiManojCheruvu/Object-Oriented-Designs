package umbcs680.ColorAdjustment.Strategy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrayScaleAdjusterTest {
    private static Image image;
    @BeforeAll
    public static void setUp(){
        image = new Image(3, 3);
        image.setColor(0, 0, new Color(255, 0, 0));
        image.setColor(1, 0, new Color(0, 255, 0));
        image.setColor(2, 0, new Color(0, 0, 255));
        image.setColor(0, 1, new Color(255, 255, 0));
        image.setColor(1, 1, new Color(255, 255, 255));
        image.setColor(2, 1, new Color(0, 0, 0));
        image.setColor(0, 2, new Color(128, 128, 128));
        image.setColor(1, 2, new Color(100, 150, 200));
        image.setColor(2, 2, new Color(50, 100, 150));
    }
    @Test
    public void gray_Scale_Adjuster(){
        ColorAdjuster adjuster = new GrayScaleAdjuster();
        Image adjustedImage = Images.transform(image, adjuster);
        ArrayList<ArrayList<Integer>> actual = new ArrayList<>();
        for (int y = 0; y < adjustedImage.getHeight(); y++) {
            for (int x = 0; x < adjustedImage.getWidth(); x++) {
                Color color = adjustedImage.getColor(x, y);
                actual.add(new ArrayList<>(List.of(color.getRedScale(), color.getGreenScale(), color.getBlueScale())));
            }
        }
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(List.of(85, 85, 85)));
        expected.add(new ArrayList<>(List.of(85, 85, 85)));
        expected.add(new ArrayList<>(List.of(85, 85, 85)));
        expected.add(new ArrayList<>(List.of(170, 170, 170)));
        expected.add(new ArrayList<>(List.of(255, 255, 255)));
        expected.add(new ArrayList<>(List.of(0,0,0)));
        expected.add(new ArrayList<>(List.of(128, 128, 128)));
        expected.add(new ArrayList<>(List.of(150, 150, 150)));
        expected.add(new ArrayList<>(List.of(100, 100, 100)));
        assertIterableEquals(expected, actual);
    }
    @Test
    void adjust_GrayScale() {
        Color color = new Color(128, 128, 128);
        GrayScaleAdjuster adjuster = new GrayScaleAdjuster();
        Color adjustedColor = adjuster.adjust(color);
        int expected = (color.getRedScale() + color.getGreenScale() + color.getBlueScale()) / 3;
        assertEquals(expected, adjustedColor.getRedScale());
        assertEquals(expected, adjustedColor.getGreenScale());
        assertEquals(expected, adjustedColor.getBlueScale());
    }

}