package umbcs680.ColorAdjustment.Lambda;

public class Color {
    private int redScale;
    private int greenScale;
    private int blueScale;
    public Color(int redScale, int greenScale, int blueScale){
        this.redScale = redScale;
        this.greenScale = greenScale;
        this.blueScale = blueScale;
    }

    public int getBlueScale() {
        return blueScale;
    }

    public int getGreenScale() {
        return greenScale;
    }

    public int getRedScale() {
        return redScale;
    }
}
