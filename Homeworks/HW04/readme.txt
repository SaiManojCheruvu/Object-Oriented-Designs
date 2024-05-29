To demonstrate State design pattern, I have made use of a Thermostat example where Thermostat has 4 states
i)  Turning on Thermostat
ii) Turning off Thermostat
iii)Increasing temperature 
iv) Decreasing temperature

By default, Temperature is set to 30 while turned on, temperature cannot be below 0 and above 100.
So, there are two states namely PowerOnState, PowerOffState.
There by forming the cases, 
i) What if user tries to turn on the thermostat while it is already on?
ii)What if user tries to increase the temperature while the thermostat is on?
iii)What if user tries to decrease the temperature while the thermostat is on?
iv)what if the user tries to turnoff the thermostat while it is on?
v)What if the user tries to turn off the thermostat while it if already off?
vi)What if the user tries to turn on the thermostat while it is off?
vii)what if the user tries to increase the temperature while the thermostat if off?
viii)what if the user tries to decrease the temperature while the thermostat if off?
Test cases for all the above questions have been written in the test cases.

