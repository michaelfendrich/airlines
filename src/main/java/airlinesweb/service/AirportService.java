package airlinesweb.service;

import airlinesweb.entity.BaggageEntity;
import airlinesweb.entity.FlightEntity;
import airlinesweb.entity.form.AirportForm;
import airlinesweb.entity.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {

    @Autowired
    private FlightRepository repository;

    private AirportForm airportForm;

    public AirportForm findAirport(AirportForm form) {
        airportForm = form;
        // checking date of flights
        List<FlightEntity> foundArrivingFlights = repository.findArrivingFlights(airportForm.getCode());
        foundArrivingFlights = checkDate(foundArrivingFlights);
        List<FlightEntity> foundDepartingFlights = repository.findDeparture(airportForm.getCode());
        foundDepartingFlights = checkDate(foundDepartingFlights);
        if(foundArrivingFlights.isEmpty() && foundDepartingFlights.isEmpty()) {
            throw new NullPointerException("No Flights Found");
        }
        airportForm.setDepartingFlights(printFlights(foundDepartingFlights));
        airportForm.setBaggagePiecesDeparting(calculatePieces(foundDepartingFlights));
        airportForm.setArrivingFlights(printFlights(foundArrivingFlights));
        airportForm.setBaggagePiecesArriving(calculatePieces(foundArrivingFlights));
        return airportForm;
    }

    private List<FlightEntity> checkDate(List<FlightEntity> list) {
        list = list.stream()
                .filter(flight -> flight.getDepartureDate().toLocalDate().isEqual(airportForm.getDate()))
                .collect(Collectors.toList());
        return list;
    }

    private String printFlights(List<FlightEntity> list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!list.isEmpty()) {
            for (FlightEntity e : list) {
                stringBuilder.append(e.getFlightNumber() + ", ");
            }
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(", "));
        } else {
            stringBuilder.append("none");
        }
        return stringBuilder.toString();
    }

    private int calculatePieces(List<FlightEntity> list) {
        int baggagePieces = 0;
        if (!list.isEmpty()) {
            for (FlightEntity e : list) {
                baggagePieces += e.getBaggage().stream().mapToInt(BaggageEntity::getPieces).sum();
            }
        }
        return baggagePieces;
    }
}
