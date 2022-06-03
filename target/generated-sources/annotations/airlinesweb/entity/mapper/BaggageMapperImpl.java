package airlinesweb.entity.mapper;

import airlinesweb.entity.BaggageEntity;
import airlinesweb.entity.FlightEntity;
import airlinesweb.entity.dto.BaggageDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 16.0.2 (Eclipse Foundation)"
)
@Component
public class BaggageMapperImpl extends BaggageMapper {

    @Override
    public BaggageEntity toEntity(BaggageDTO source) {
        if ( source == null ) {
            return null;
        }

        BaggageEntity baggageEntity = new BaggageEntity();

        baggageEntity.setId( source.getId() );
        baggageEntity.setWeight( source.getWeight() );
        baggageEntity.setWeightUnit( source.getWeightUnit() );
        baggageEntity.setPieces( source.getPieces() );

        baggageEntity.setFlight( mapToFlightEntity(source) );

        return baggageEntity;
    }

    @Override
    public BaggageDTO toDTO(BaggageEntity source) {
        if ( source == null ) {
            return null;
        }

        BaggageDTO baggageDTO = new BaggageDTO();

        baggageDTO.setFlightId( sourceFlightFlightId( source ) );
        baggageDTO.setId( source.getId() );
        baggageDTO.setWeight( source.getWeight() );
        baggageDTO.setWeightUnit( source.getWeightUnit() );
        baggageDTO.setPieces( source.getPieces() );

        return baggageDTO;
    }

    private Long sourceFlightFlightId(BaggageEntity baggageEntity) {
        if ( baggageEntity == null ) {
            return null;
        }
        FlightEntity flight = baggageEntity.getFlight();
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
