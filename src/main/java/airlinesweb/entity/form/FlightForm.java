package airlinesweb.entity.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class FlightForm {

    private int flightNumber;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfFlight;

    private String dateAndTime;
    private int kgCargoWeight;
    private int lbCargoWeight;
    private int kgBaggageWeight;
    private int lbBaggageWeight;
    private int kgTotalWeight;
    private int lbTotalWeight;
}
