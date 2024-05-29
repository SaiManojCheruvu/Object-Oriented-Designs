package umbcs680.ThermostatApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThermostatTest {
    //Default test cases
    @Test
    public void default_Thermostat_Off_Test(){
        Thermostat thermostat = new Thermostat();
        assertEquals(thermostat.getState().getClass(), PowerOffState.class);
    }
    @Test
    public void thermostat_default_30_Temp_on_Turning_on_Test() throws Exception {
        Thermostat thermostat = new Thermostat();
        thermostat.powerOn();
        assertEquals(30, thermostat.getCurrentTemp());
    }
    // State behaviour test cases

    //i)Turned on state test cases
    @Test
    public void temperature_Increase_after_Thermostat_TurnedOn() throws Exception {
        Thermostat thermostat = new Thermostat();
        thermostat.powerOn();
        assertEquals(30, thermostat.getCurrentTemp());
        thermostat.increaseTemperature();
        assertEquals(31, thermostat.getCurrentTemp());
    }
    @Test
    public void temperature_Decrease_after_Thermostat_TurnedOn() throws Exception {
        Thermostat thermostat = new Thermostat();
        thermostat.powerOn();
        assertEquals(30, thermostat.getCurrentTemp());
        thermostat.decreaseTemperature();
        assertEquals(29, thermostat.getCurrentTemp());
    }
    @Test
    public void trying_to_turn_thermostat_on_while_TurnedOn() throws Exception{
        Thermostat thermostat = new Thermostat();
        thermostat.powerOn();
        try {
            thermostat.powerOn();
            fail("Thermostat already on Exception not thrown");
        }catch (Exception e){
            assertEquals("Thermostat is already turned on", e.getMessage());
        }
    }
    @Test
    public void turning_off_thermostat_while_TurnedOn() throws Exception {
        Thermostat thermostat = new Thermostat();
        thermostat.powerOn();
        assertEquals(thermostat.getState().getClass(), PowerOnState.class);
        thermostat.powerOff();
        assertEquals(thermostat.getState().getClass(), PowerOffState.class);

    }

    //Turned off Test cases
    @Test
    public void trying_To_Turn_off_while_TurnedOff_Test(){
        Thermostat thermostat = new Thermostat();
        assertEquals(thermostat.getState().getClass(), PowerOffState.class);
        try {
            thermostat.powerOff();
            fail("Trying to turn off while already turned off Exception not caught");
        }catch (Exception e){
            assertEquals("Thermostat already off", e.getMessage());
        }
    }

    @Test
    public void turning_On_Thermostat_while_TurnedOff_Test() throws Exception {
        Thermostat thermostat = new Thermostat();
        assertEquals(thermostat.getState().getClass(), PowerOffState.class);
        thermostat.powerOn();
        assertEquals(thermostat.getState().getClass(), PowerOnState.class);
    }
    @Test
    public void trying_to_increase_temperature_while_TurnedOff_Test(){
        Thermostat thermostat = new Thermostat();
        assertEquals(thermostat.getState().getClass(), PowerOffState.class);
        try {
            thermostat.increaseTemperature();
            fail("Trying to increase temperature while turned off Exception not caught");
        }catch (Exception e){
            assertEquals("Thermostat is off, turn it on to increase the temperature", e.getMessage());
        }
    }
    @Test
    public void trying_to_decrease_temperature_while_TurnedOff_Test(){
        Thermostat thermostat = new Thermostat();
        assertEquals(thermostat.getState().getClass(), PowerOffState.class);
        try {
            thermostat.decreaseTemperature();
            fail("Trying to decrease the temperature while turned off Exception not caught");
        }catch (Exception e){
            assertEquals("Thermostat is off, turn it on to decrease the temperature", e.getMessage());
        }
    }


    //Edge cases
    @Test
    public void temperature_cannot_be_less_than_0_test() throws Exception {
        Thermostat thermostat = new Thermostat();
        thermostat.powerOn();
        for(int i = 30; i > 0; i--){
            thermostat.decreaseTemperature();
        }
        try {
            thermostat.decreaseTemperature();
            fail("Temperature cannot be less than 0 Exception not caught");
        }catch (Exception e){
            assertEquals("Thermostat temperature cannot be less than 0", e.getMessage());
        }
    }
    @Test
    public void temperature_cannot_be_greater_than_100() throws Exception {
        Thermostat thermostat = new Thermostat();
        thermostat.powerOn();
        for(int i = 0; i < 71; i++){
            thermostat.increaseTemperature();
        }
        try {
            thermostat.increaseTemperature();
            fail("Temperature cannot be greater than 100 Exception not caught");
        }catch (Exception e){
            assertEquals("Thermostat temperature cannot be greater than 100", e.getMessage());
        }
    }

}