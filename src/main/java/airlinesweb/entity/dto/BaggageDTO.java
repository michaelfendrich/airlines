package airlinesweb.entity.dto;

import airlinesweb.constant.UnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaggageDTO {

    private Long id;
    private int weight;
    private UnitType weightUnit;
    private int pieces;

    private Long flightId;
}
