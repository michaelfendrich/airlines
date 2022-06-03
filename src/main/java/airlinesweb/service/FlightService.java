package airlinesweb.service;

import airlinesweb.constant.UnitType;
import airlinesweb.entity.FlightEntity;
import airlinesweb.entity.FreightInterface;
import airlinesweb.entity.repository.FlightRepository;
import airlinesweb.entity.form.FlightForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository repository;

    private FlightEntity entity;

    public FlightEntity addItem(FlightEntity entity) {
        return repository.save(entity);
    }

    public FlightForm findByNumber(FlightForm form) {
        this.entity = repository.findByNumber(form.getFlightNumber());
        if(!entity.getDepartureDate().toLocalDate().isEqual(form.getDateOfFlight())) {
            throw new IllegalArgumentException("Flight not found");
        }
        form.setDateAndTime(entity.getDepartureDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        int kgCargoWeight = calculateWeight(entity.getCargo());
        form.setKgCargoWeight(kgCargoWeight);
        form.setLbCargoWeight((int) (kgCargoWeight * 2.20462262f));
        int kgBaggageWeight = calculateWeight(entity.getBaggage());
        form.setKgBaggageWeight(kgBaggageWeight);
        form.setLbBaggageWeight((int) (kgBaggageWeight * 2.20462262f));
        form.setKgTotalWeight(form.getKgBaggageWeight() + form.getKgCargoWeight());
        form.setLbTotalWeight(form.getLbBaggageWeight() + form.getLbCargoWeight());
        return form;
    }

    private int calculateWeight(List<? extends FreightInterface> list) {
        int kgWeight = 0;
        for (FreightInterface f : list) {
            if (f.getWeightUnit() == UnitType.KG) {
                kgWeight += f.getWeight();
            } else {
                kgWeight += f.getWeight() * 0.45359237f;
            }
        }
        return kgWeight;
    }
}
