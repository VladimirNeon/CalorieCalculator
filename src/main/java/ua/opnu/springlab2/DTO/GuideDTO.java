package ua.opnu.springlab2.DTO;

import lombok.Data;

@Data
public class GuideDTO {
    private Long id;
    private String name;
    private String language;
    private int experienceYears;
}
