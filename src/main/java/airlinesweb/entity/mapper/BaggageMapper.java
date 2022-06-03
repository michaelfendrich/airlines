package airlinesweb.entity.mapper;


import airlinesweb.entity.BaggageEntity;
import airlinesweb.entity.FlightEntity;
import airlinesweb.entity.dto.BaggageDTO;
import airlinesweb.entity.repository.FlightRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class BaggageMapper {

    @Autowired
    private FlightRepository repository;

    @Mapping(target = "flight", expression = "java(mapToFlightEntity(source))")
    public abstract BaggageEntity toEntity(BaggageDTO source);

    @Mapping(target = "flightId", source = "flight.flightId")
    public abstract BaggageDTO toDTO(BaggageEntity source);

    protected FlightEntity mapToFlightEntity(BaggageDTO baggageDTO) {
        return repository.getOne(baggageDTO.getFlightId());
    }
}
