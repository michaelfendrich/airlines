package airlinesweb.entity.mapper;

import airlinesweb.entity.CargoEntity;
import airlinesweb.entity.FlightEntity;
import airlinesweb.entity.dto.CargoDTO;
import airlinesweb.entity.repository.FlightRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CargoMapper {

    @Autowired
    private FlightRepository repository;

    @Mapping(target = "flight", expression = "java(mapToFlightEntity(source))")
    public abstract CargoEntity toEntity(CargoDTO source);

    @Mapping(target = "flightId", source = "flight.flightId")
    public abstract CargoDTO toDTO(CargoEntity source);

    protected FlightEntity mapToFlightEntity(CargoDTO cargoDTO) {
        return repository.getOne(cargoDTO.getFlightId());
    }
}
