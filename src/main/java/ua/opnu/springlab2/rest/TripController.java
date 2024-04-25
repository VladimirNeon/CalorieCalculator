package ua.opnu.springlab2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.opnu.springlab2.model.Trip;
import ua.opnu.springlab2.service.TripService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTrips() {
        List<Trip> trips = tripService.getAllTrips();
        return ResponseEntity.ok(trips);
    }


    @GetMapping("/destination")
    public ResponseEntity<?> getTripsByDestination(@RequestParam String destination) {
        List<Trip> trips = tripService.getTripsByDestination(destination);
        return ResponseEntity.ok(trips);
    }

    @GetMapping("/duration")
    public ResponseEntity<?> getTripsWithDurationGreaterThan(@RequestParam int duration) {
        List<Trip> trips = tripService.getTripsWithDurationGreaterThan(duration);
        return ResponseEntity.ok(trips);
    }

    @GetMapping("/popular")
    public ResponseEntity<?> getTop3PopularDestinations() {
        List<String> topDestinations = tripService.findTop3PopularDestinations();
        return ResponseEntity.ok(topDestinations);
    }

    @GetMapping("/price")
    public ResponseEntity<?> getTripsByPriceLessThan(@RequestParam double price) {
        List<Trip> trips = tripService.getTripsByPriceLessThan(price);
        return ResponseEntity.ok(trips);
    }

}

