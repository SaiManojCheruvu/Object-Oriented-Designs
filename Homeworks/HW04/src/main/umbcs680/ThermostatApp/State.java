package umbcs680.ThermostatApp;

public interface State {
    public abstract void powerOn() throws Exception;
    public abstract void powerOff() throws Exception;
    public abstract void increaseTemperature() throws Exception;
    public abstract void decreaseTemperature() throws Exception;
}
