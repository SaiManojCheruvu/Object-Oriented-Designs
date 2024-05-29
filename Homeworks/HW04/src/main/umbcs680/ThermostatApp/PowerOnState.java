package umbcs680.ThermostatApp;

public class PowerOnState implements State {
    private Thermostat thermostat;

    public PowerOnState(Thermostat thermostat){
        this.thermostat = thermostat;
    }

    @Override
    public void powerOn() throws Exception {
        throw new Exception("Thermostat is already turned on");
    }

    @Override
    public void powerOff() {
        System.out.println("Turning off thermostat");
        this.thermostat.setState(new PowerOffState(this.thermostat));
    }

    @Override
    public void increaseTemperature() throws Exception {
        System.out.println("Increasing the temperature");
        this.thermostat.incrementCurrentTemperature();
    }

    @Override
    public void decreaseTemperature() throws Exception {
        System.out.println("Decreasing the temperature");
        this.thermostat.decrementCurrentTemperature();
    }
}
