package ua.opnu.springlab2.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.opnu.springlab2.model.Guide;

import java.util.List;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {
    // Метод для получения информации обо всех гидах и поездках, которые они проводят, включая информацию о туристических пакетах
    @Query("SELECT g FROM Guide g JOIN FETCH g.trips t JOIN FETCH t.travelPackage")
    List<Guide> findAllGuidesWithTripsAndTravelPackages();
}
