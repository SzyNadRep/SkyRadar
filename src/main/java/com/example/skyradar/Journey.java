package com.example.skyradar;

public class Journey {
    public Flight first;
    public Flight second;

    FlightDatabase flightDatabase;

    public Journey(Flight first, Flight second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Flight from " + first.departure + " to "
                + second.arrival + " with stop at " + first.arrival
                + " costs " + (first.price + second.price);
    }
}
