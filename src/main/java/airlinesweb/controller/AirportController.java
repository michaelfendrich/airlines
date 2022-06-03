package airlinesweb.controller;

import airlinesweb.entity.form.AirportForm;
import airlinesweb.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AirportController {

    @Autowired
    private AirportService service;

    AirportForm airport = new AirportForm();

    @GetMapping("/airport")
    public String printIndex(Model model) {
        model.addAttribute("airport", airport);
        return "airport-index";
    }

    @PostMapping("/airport-result")
    public String findAirport(@ModelAttribute AirportForm form, Model model) {
        airport = service.findAirport(form);
        model.addAttribute("airport", airport);
        return "airport-results";
    }
}
