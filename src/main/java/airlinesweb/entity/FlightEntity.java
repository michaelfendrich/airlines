package airlinesweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "flights")
@NoArgsConstructor
@Data
public class FlightEntity {

    @Id
    private Long flightId;

    @Column(nullable = false)
    private int flightNumber;
    private String departureAirportIATACode;
    private String arrivalAirportIATACode;
    private LocalDateTime departureDate;

    @OneToMany(mappedBy = "flight")
    private List<BaggageEntity> baggage;

    @OneToMany(mappedBy = "flight")
    private List<CargoEntity> cargo;
}
