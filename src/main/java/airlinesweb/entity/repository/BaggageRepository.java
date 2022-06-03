package airlinesweb.entity.repository;

import airlinesweb.entity.BaggageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaggageRepository extends JpaRepository<BaggageEntity, Long> {
}
