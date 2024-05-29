package umbcs680.ThermostatApp;
public class PowerOffState implements State{
    private Thermostat thermostat;
    public PowerOffState(Thermostat thermostat){
        this.thermostat = thermostat;
    }
    @Override
    public void powerOn() {
        System.out.println("Turning on Thermostat");
        this.thermostat.setState(new PowerOnState(this.thermostat));
    }

    @Override
    public void powerOff() throws Exception {
        throw new Exception("Thermostat already off");
    }

    @Override
    public void increaseTemperature() throws Exception {
        throw new Exception("Thermostat is off, turn it on to increase the temperature");
    }

    @Override
    public void decreaseTemperature() throws Exception {
        throw new Exception("Thermostat is off, turn it on to decrease the temperature");
    }
}
