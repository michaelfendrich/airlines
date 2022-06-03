package airlinesweb.controller;

import airlinesweb.entity.FlightEntity;
import airlinesweb.entity.dto.BaggageDTO;
import airlinesweb.entity.dto.CargoDTO;
import airlinesweb.service.BaggageService;
import airlinesweb.service.CargoService;
import airlinesweb.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/automatic/posting")
public class JSONpostingController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private BaggageService baggageService;

    @Autowired
    private CargoService cargoService;

    @PostMapping("/flights")
    public void addItem(@RequestBody FlightEntity entity) {
        flightService.addItem(entity);
    }

    @PostMapping("/baggage")
    public void addItem(@RequestBody BaggageDTO baggageDTO) { baggageService.addItem(baggageDTO);}

    @PostMapping("/cargo")
    public void addIteam(@RequestBody CargoDTO cargoDTO) { cargoService.addItem(cargoDTO);}
}
