package ua.opnu.springlab2.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.opnu.springlab2.model.TravelPackage;

import java.util.Date;
import java.util.List;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {

    @Query("SELECT tp FROM TravelPackage tp JOIN FETCH tp.trips t WHERE tp.startDate BETWEEN :start AND :end OR tp.endDate BETWEEN :start AND :end")
    List<TravelPackage> findTravelPackagesAvailableInDateRange(@Param("start") Date startDate, @Param("end") Date endDate);
}

