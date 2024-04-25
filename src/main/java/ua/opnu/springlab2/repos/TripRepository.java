package ua.opnu.springlab2.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.opnu.springlab2.model.Trip;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findByDestination(String destination);

    List<Trip> findByDurationGreaterThan(int duration);

    @Query("SELECT t.destination FROM Trip t GROUP BY t.destination ORDER BY COUNT(t.destination) DESC LIMIT 3")
    List<String> findTop3PopularDestinations();

    List<Trip> findByPriceLessThan(double price);
}


