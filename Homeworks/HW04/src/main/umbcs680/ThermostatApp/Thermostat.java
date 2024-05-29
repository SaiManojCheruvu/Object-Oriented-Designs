package umbcs680.ThermostatApp;
public class Thermostat {
    private State state;
    private int currentTemperature;
    public Thermostat(){
        this.state = new PowerOffState(this);
    }
    public void setState(State state){
        this.state = state;
    }
    public void powerOn() throws Exception {
        this.state.powerOn();
        if(this.state instanceof PowerOnState){
            this.currentTemperature = 30; // Default temperature
        }
    }

    public void powerOff() throws Exception {
        this.state.powerOff();
    }


    public void increaseTemperature() throws Exception {
        state.increaseTemperature();
    }


    public void decreaseTemperature() throws Exception {
        state.decreaseTemperature();
    }
    public int getCurrentTemp() {
        return currentTemperature;
    }

    public void incrementCurrentTemperature() throws Exception {
        if(this.currentTemperature > 100){
            throw new Exception("Thermostat temperature cannot be greater than 100");
        }
        this.currentTemperature++;
        System.out.println("Current temperature: " + this.currentTemperature);
    }

    public void decrementCurrentTemperature() throws Exception {
        if(this.currentTemperature > 0){
            this.currentTemperature--;
            System.out.println("Current temperature: " + this.currentTemperature);
        }else{
            throw new Exception("Thermostat temperature cannot be less than 0");
        }

    }
    public State getState(){
        return this.state;
    }
}
