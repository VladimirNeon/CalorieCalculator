package ua.opnu.springlab2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.opnu.springlab2.model.Trip;
import ua.opnu.springlab2.repos.TripRepository;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public List<Trip> getTripsByDestination(String destination) {
        return tripRepository.findByDestination(destination);
    }

    public List<Trip> getTripsWithDurationGreaterThan(int duration) {
        return tripRepository.findByDurationGreaterThan(duration);
    }

    public List<String> findTop3PopularDestinations() {
        return tripRepository.findTop3PopularDestinations();
    }

    public List<Trip> getTripsByPriceLessThan(double price) {
        return tripRepository.findByPriceLessThan(price);
    }


}




