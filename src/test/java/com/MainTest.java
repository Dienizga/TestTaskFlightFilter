package com;

import com.filter.FlightFilterImpl;
import com.flight.Flight;
import com.flight.FlightBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
   FlightFilterImpl flightFilter = new FlightFilterImpl();
    List<Flight> flights = FlightBuilder.createFlights();

    @Test
    void departureCurrentTime() {
        long actual = flightFilter.departureCurrentTime(flights).size();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void arrivalBeforeDeparture() {
        long actual = flightFilter.arrivalBeforeDeparture(flights).size();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void moreTwoHoursGroundTime() {
        long actual = flightFilter.departureCurrentTime(flights).size();
        int expected = 1;
        assertEquals(expected, actual);
    }
}