package airlinesweb.service;

import airlinesweb.entity.BaggageEntity;
import airlinesweb.entity.dto.BaggageDTO;
import airlinesweb.entity.mapper.BaggageMapper;
import airlinesweb.entity.repository.BaggageRepository;
import airlinesweb.entity.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaggageService {

    @Autowired
    private BaggageRepository baggageRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private BaggageMapper baggageMapper;

    public BaggageDTO addItem(BaggageDTO baggageDTO) {
        BaggageEntity entity = baggageMapper.toEntity(baggageDTO);
        BaggageEntity saved = baggageRepository.save(entity);
        return baggageMapper.toDTO(saved);
    }
}
