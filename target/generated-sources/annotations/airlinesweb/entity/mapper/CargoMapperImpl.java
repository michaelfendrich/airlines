package airlinesweb.entity.mapper;

import airlinesweb.entity.CargoEntity;
import airlinesweb.entity.FlightEntity;
import airlinesweb.entity.dto.CargoDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 16.0.2 (Eclipse Foundation)"
)
@Component
public class CargoMapperImpl extends CargoMapper {

    @Override
    public CargoEntity toEntity(CargoDTO source) {
        if ( source == null ) {
            return null;
        }

        CargoEntity cargoEntity = new CargoEntity();

        cargoEntity.setId( source.getId() );
        cargoEntity.setWeight( source.getWeight() );
        cargoEntity.setWeightUnit( source.getWeightUnit() );
        cargoEntity.setPieces( source.getPieces() );

        cargoEntity.setFlight( mapToFlightEntity(source) );

        return cargoEntity;
    }

    @Override
    public CargoDTO toDTO(CargoEntity source) {
        if ( source == null ) {
            return null;
        }

        CargoDTO cargoDTO = new CargoDTO();

        cargoDTO.setFlightId( sourceFlightFlightId( source ) );
        cargoDTO.setId( source.getId() );
        cargoDTO.setWeight( source.getWeight() );
        cargoDTO.setWeightUnit( source.getWeightUnit() );
        cargoDTO.setPieces( source.getPieces() );

        return cargoDTO;
    }

    private Long sourceFlightFlightId(CargoEntity cargoEntity) {
        if ( cargoEntity == null ) {
            return null;
        }
        FlightEntity flight = cargoEntity.getFlight();
        if ( flight == null ) {
            return null;
        }
        Long flightId = flight.getFlightId();
        if ( flightId == null ) {
            return null;
        }
        return flightId;
    }
}
