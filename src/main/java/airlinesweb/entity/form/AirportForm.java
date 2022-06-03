package airlinesweb.entity.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AirportForm {

    private String code;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String departingFlights;
    private String arrivingFlights;
    private int baggagePiecesArriving;
    private int baggagePiecesDeparting;
}
