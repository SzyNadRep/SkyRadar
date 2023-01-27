package com.example.skyradar;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FlightDatabase {
    private ArrayList<Flight> flightList = new ArrayList<Flight>();

    public FlightDatabase() {
        this.flightList.add(new Flight("Berlin", "Tokyo", 1800));
        this.flightList.add(new Flight("Paris", "Berlin", 1300));
        this.flightList.add(new Flight("Warsaw", "Paris", 1000));
        this.flightList.add(new Flight("Madrid", "Berlin", 500));
        this.flightList.add(new Flight("Berlin", "Warsaw", 750));
        this.flightList.add(new Flight("Paris", "Madrid", 100));
        this.flightList.add(new Flight("Porto", "Warsaw", 450));
        this.flightList.add(new Flight("Madrid", "Porto",3300));
        this.flightList.add(new Flight("Warsaw", "Madrid", 600));
    }

    public void checkIfFlightExists(String departure, String arrival){
        for(int i=0; i<flightList.size();i++){
            Flight flight = this.flightList.get(i);
            if(departure.equals(flight.arrival) && arrival.equals(flight.arrival))
            if(flightList.equals(departure) && flightList.equals(arrival)){
                System.out.println("This fly is existing!");
                return;
            }
        }
    }

    public void getFlightToCity(String cityName){
        boolean isNotFound = true;
        for (Flight flight : this.flightList) {
            if (cityName.equals(flight.arrival)) {
                flight.getDetails();
                isNotFound = false;
            }
        }
        if(isNotFound){
            System.out.println("Flight not found");
        }
    }

    public void getFlightFromCity(String startCity){
        for (Flight flight : flightList) {
            if (startCity.equals(flight.departure)) {
                flight.getDetails();
            }
        }
    }

    public void displayFlights(@NotNull ArrayList<Flight> results){
        if(results.isEmpty()){
            System.out.println("FLight not found");
        }
        for (Flight flight : results) {
            flight.getDetails();
        }
    }

    public ArrayList<Flight> getFlightListFromCity(String cityName){
        ArrayList<Flight> tempFlightList = new ArrayList<Flight>();

        for (Flight flight : this.flightList) {
            if (cityName.equals(flight.departure)) {
                tempFlightList.add(flight);
            }
        }
        return tempFlightList;
    }

    public ArrayList<Flight> getFlightListToCity(String cityName){
        ArrayList<Flight> tempFlightList = new ArrayList<Flight>();

        for (Flight flight : this.flightList) {
            if (cityName.equals(flight.arrival)) {
                tempFlightList.add(flight);
            }
        }
        return tempFlightList;
    }

    public void displayFlightsFromCity(String cityName){
        ArrayList<Flight> results = getFlightListFromCity(cityName);
        displayFlights(results);
    }

    public void displayFlightsToCity(String cityName){
        ArrayList<Flight> results = getFlightListToCity(cityName);
        displayFlights(results);
    }

    public ArrayList<String> getCity(){
        ArrayList<String> results = new ArrayList<>();
        for (Flight flight : this.flightList) {
            if (!results.contains(flight.arrival)) {
                results.add(flight.arrival);
            }
            if (!results.contains(flight.departure)) {
                results.add(flight.departure);
            }
        }
        return results;
    }

    public Flight getCheapestFlight(){
        Flight cheapestFlight = null;
        for (Flight flight : this.flightList){
            if(cheapestFlight == null || flight.price < cheapestFlight.price){
                cheapestFlight = flight;
            }
        }
        return cheapestFlight;
    }

    public Flight getCheapestFlightFromCity(String cityName){
        ArrayList<Flight> fromCity = getFlightListFromCity(cityName);
        Flight cheapestFlight = null;
        for (Flight flight : fromCity){
            if(cheapestFlight == null || flight.price < cheapestFlight.price){
                    cheapestFlight = flight;
            }
        }
        return cheapestFlight;
    }

    public ArrayList<Flight> getFlight(String start, String end){
        ArrayList<Flight> starting = getFlightListFromCity(start);
        ArrayList<Flight> ending = getFlightListToCity(end);
        ArrayList<Flight> result = new ArrayList<Flight>();

        for (Flight first : starting){
            for (Flight second : ending){
                if(first.arrival.equals(second.departure)){
                    result.add(first);
                    result.add(second);
                }
            }
        }

        return result;

    }

    public ArrayList<Journey> getFlights(String start, String end){
        ArrayList<Flight> starting = getFlightListFromCity(start);
        ArrayList<Flight> ending = getFlightListToCity(end);

        ArrayList<Journey> results = new ArrayList<Journey>();

        for(Flight first : starting){
            for (Flight second : ending){
                if ((first.arrival.equals(second.departure))){
                    results.add(new Journey(first, second));
                }
            }
        }
        return  results;
    }
}
