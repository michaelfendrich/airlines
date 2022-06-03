package airlinesweb.entity;

import airlinesweb.constant.UnitType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "cargo")
@Data
@NoArgsConstructor
public class CargoEntity implements FreightInterface {

    @Id
    private Long id;

    private int weight;

    @Enumerated(value = EnumType.STRING)
    private UnitType weightUnit;

    private int pieces;

    @ManyToOne
    @JoinColumn(name="flightId")
    private FlightEntity flight;
}
