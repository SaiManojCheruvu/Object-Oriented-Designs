The example is an implementation of multicast design pattern (Many - Many - relationship)
Here Observables are
- Weather data
- Stock data
A new set of values can be passed using a List into the class.
On the other hand, the observers are
- Linear Regression Observer
- Exponential Smoothing observer
- Moving Average Observer

In this many - many - relationship, it is a cross product of observers and observables.
i.e Both weather data and stock data can be passed into all of the algorithms i.e Linear regression, Exponential smoothing and Moving average observers.

Note: If required we can have some observers implement only some observables.
Eg: We can have Exponential smoothing observer not implementing stock data observable.
But in this example, We have all the observables being implemented by all of the observers.


