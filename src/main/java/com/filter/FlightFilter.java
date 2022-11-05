package com.filter;

import com.flight.Flight;

import java.util.List;

public interface FlightFilter {
    List<Flight> departureCurrentTime(List<Flight> flightList);
    List<Flight> arrivalBeforeDeparture(List<Flight> flightList);
    List<Flight> moreTwoHoursGroundTime(List<Flight> flightList);
}
