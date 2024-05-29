package umbcs680.ColorAdjustment.Lambda;
public class Images {
    public static Image transform(Image image, ColorAdjuster adjuster){
        Image adjusted= new Image(image.getHeight(), image.getWidth());
        for(int y = 0; y < image.getHeight(); y++){
            for(int x = 0; x < image.getWidth(); x++){
                Color original = image.getColor(x, y);
                Color adjustedColor = adjuster.adjust(original);
                adjusted.setColor(x, y, adjustedColor);
            }
        }
        return adjusted;
    }
}