package airlinesweb.service;

import airlinesweb.entity.CargoEntity;
import airlinesweb.entity.dto.CargoDTO;
import airlinesweb.entity.mapper.CargoMapper;
import airlinesweb.entity.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoService {

    @Autowired
    private CargoMapper cargoMapper;

    @Autowired
    private CargoRepository cargoRepository;

    public CargoDTO addItem(CargoDTO cargoDTO) {
        CargoEntity entity = cargoMapper.toEntity(cargoDTO);
        CargoEntity saved = cargoRepository.save(entity);
        return cargoMapper.toDTO(saved);
    }
}
