package com.filter;

import com.flight.Flight;
import com.flight.Segment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterImpl implements FlightFilter {

    @Override
    public List<Flight> departureCurrentTime(List<Flight> flightList) {
        return flightList.stream().filter(f -> f.getSegments().stream()
                        .allMatch(s -> s.getDepartureDate().isBefore(LocalDateTime.now())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> arrivalBeforeDeparture(List<Flight> flightList) {
        return flightList.stream().filter(f -> f.getSegments().stream()
                        .allMatch(s -> s.getArrivalDate().isBefore(s.getDepartureDate())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> moreTwoHoursGroundTime(List<Flight> flightList) {
        return flightList.stream().filter(f -> {
                    List<Segment> segmentList = f.getSegments();
                    long groundTime = 0;
                    for (int i = 0; i < segmentList.size() - 1; i++) {
                        LocalDateTime arrival = segmentList.get(i).getArrivalDate();
                        LocalDateTime departureNext = segmentList.get(i + 1).getDepartureDate();
                        groundTime += arrival.until(departureNext, ChronoUnit.MINUTES);
                    }
                    int minutes = 60;
                    return groundTime / minutes <= 2;
                })
                .collect(Collectors.toList());
    }
}
