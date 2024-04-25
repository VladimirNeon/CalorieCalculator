package ua.opnu.springlab2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.springlab2.DTO.GuideDTO;
import ua.opnu.springlab2.model.Guide;
import ua.opnu.springlab2.repos.GuideRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class GuideService {

    private final GuideRepository guideRepository;

    @Autowired
    public GuideService(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    public List<GuideDTO> getAllGuides() {
        List<Guide> guides = guideRepository.findAll();
        return guides.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public GuideDTO getGuideById(Long id) {
        Guide guide = guideRepository.findById(id).orElse(null);
        if (guide == null) {
            return null;
        }
        return convertToDTO(guide);
    }

    public List<GuideDTO> findAllGuidesWithTripsAndTravelPackages() {
        List<Guide> guides = guideRepository.findAllGuidesWithTripsAndTravelPackages();
        return guides.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    private GuideDTO convertToDTO(Guide guide) {
        GuideDTO guideDTO = new GuideDTO();
        guideDTO.setId(guide.getId());
        guideDTO.setName(guide.getName());
        guideDTO.setLanguage(guide.getLanguage());
        guideDTO.setExperienceYears(guide.getExperienceYears());

        return guideDTO;
    }
}

