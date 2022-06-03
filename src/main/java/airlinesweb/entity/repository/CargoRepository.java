package airlinesweb.entity.repository;

import airlinesweb.entity.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<CargoEntity, Long> {
}
