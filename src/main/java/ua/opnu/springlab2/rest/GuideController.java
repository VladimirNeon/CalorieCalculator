package ua.opnu.springlab2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.opnu.springlab2.DTO.GuideDTO;
import ua.opnu.springlab2.service.GuideService;

import java.util.List;

@RestController
@RequestMapping("/guides")
public class GuideController {

    private final GuideService guideService;

    @Autowired
    public GuideController(GuideService guideService) {
        this.guideService = guideService;
    }

    @GetMapping
    public ResponseEntity<List<GuideDTO>> getAllGuides() {
        List<GuideDTO> guides = guideService.getAllGuides();
        return new ResponseEntity<>(guides, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuideDTO> getGuideById(@PathVariable Long id) {
        GuideDTO guideDTO = guideService.getGuideById(id);
        if (guideDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(guideDTO, HttpStatus.OK);
    }

    @GetMapping("/with-trips-and-packages")
    public ResponseEntity<List<GuideDTO>> getAllGuidesWithTripsAndTravelPackages() {
        List<GuideDTO> guides = guideService.findAllGuidesWithTripsAndTravelPackages();
        return new ResponseEntity<>(guides, HttpStatus.OK);
    }
}
