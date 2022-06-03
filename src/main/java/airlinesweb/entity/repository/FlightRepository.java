package airlinesweb.entity.repository;

import airlinesweb.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

    @Query(value = "SELECT * FROM `flights` WHERE `flight_number` = :flightNo LIMIT 1", nativeQuery = true)
    FlightEntity findByNumber(@Param("flightNo")int flightNumber);

    @Query(value = "SELECT * FROM `flights` WHERE `arrival_airportiatacode` = :airport", nativeQuery = true)
    List<FlightEntity> findArrivingFlights(@Param("airport")String code);

    @Query(value = "SELECT * FROM `flights` WHERE `departure_airportiatacode` = :airport", nativeQuery = true)
    List<FlightEntity> findDeparture(@Param("airport")String code);
}
