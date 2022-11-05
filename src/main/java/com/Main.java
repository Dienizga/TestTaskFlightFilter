package com;

import com.filter.FlightFilterImpl;
import com.flight.FlightBuilder;

public class Main {
    public static void main(String[] args) {
        FlightFilterImpl flightFilter = new FlightFilterImpl();

        System.out.println("Общее:");
        System.out.println(FlightBuilder.createFlights());

        System.out.println("Вылет до текущего момента времени:");
        System.out.println(flightFilter.departureCurrentTime(FlightBuilder.createFlights()));

        System.out.println("Имеются сегменты с датой прилёта раньше даты вылета:");
        System.out.println(flightFilter.arrivalBeforeDeparture(FlightBuilder.createFlights()));

        System.out.println("Общее время, проведённое на земле превышает два часа (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним):");
        System.out.println(flightFilter.moreTwoHoursGroundTime(FlightBuilder.createFlights()));
    }
}
