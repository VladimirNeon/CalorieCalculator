package ua.opnu.springlab2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.opnu.springlab2.DTO.TravelPackageDTO;
import ua.opnu.springlab2.model.TravelPackage;
import ua.opnu.springlab2.repos.TravelPackageRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelPackageService {

    private final TravelPackageRepository travelPackageRepository;

    @Autowired
    public TravelPackageService(TravelPackageRepository travelPackageRepository) {
        this.travelPackageRepository = travelPackageRepository;
    }

    public List<TravelPackageDTO> getTravelPackagesInDateRange(Date startDate, Date endDate) {
        List<TravelPackage> travelPackages = travelPackageRepository.findTravelPackagesAvailableInDateRange(startDate, endDate);
        return travelPackages.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    private TravelPackageDTO convertToDTO(TravelPackage travelPackage) {
        TravelPackageDTO dto = new TravelPackageDTO();
        dto.setId(travelPackage.getId());
        dto.setName(travelPackage.getName());
        dto.setDescription(travelPackage.getDescription());
        dto.setStartDate(travelPackage.getStartDate());
        dto.setEndDate(travelPackage.getEndDate());
        return dto;
    }
}



