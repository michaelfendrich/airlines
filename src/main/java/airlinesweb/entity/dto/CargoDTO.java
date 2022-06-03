package airlinesweb.entity.dto;

import airlinesweb.constant.UnitType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CargoDTO {

    private Long id;
    private int weight;
    private UnitType weightUnit;
    private int pieces;

    private Long flightId;
}
