package ua.opnu.springlab2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.opnu.springlab2.DTO.TravelPackageDTO;
import ua.opnu.springlab2.service.TravelPackageService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class TravelPackageController {

    private final TravelPackageService travelPackageService;

    @Autowired
    public TravelPackageController(TravelPackageService travelPackageService) {
        this.travelPackageService = travelPackageService;
    }

    @GetMapping("/travel-packages")
    public ResponseEntity<List<TravelPackageDTO>> getTravelPackagesInDateRange(
            @RequestParam("start-date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam("end-date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        List<TravelPackageDTO> travelPackages = travelPackageService.getTravelPackagesInDateRange(startDate, endDate);
        return new ResponseEntity<>(travelPackages, HttpStatus.OK);
    }
}
