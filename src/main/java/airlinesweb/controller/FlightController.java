package airlinesweb.controller;

import airlinesweb.entity.form.FlightForm;
import airlinesweb.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FlightController {

    @Autowired
    private FlightService service;

    private FlightForm flight = new FlightForm();

    @GetMapping("/flights")
    public String printFlightIndex(Model model) {
        model.addAttribute("flight", flight);
        return "flight-index";
    }

    @PostMapping("/flight-result")
    public String showResult(@ModelAttribute FlightForm form, Model model) {
        flight = service.findByNumber(form);
        model.addAttribute("form", flight);
        return "flight-result";
    }
}
