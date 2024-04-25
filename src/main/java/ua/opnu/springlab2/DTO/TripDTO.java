package ua.opnu.springlab2.DTO;

import lombok.Data;

@Data
public class TripDTO {
    private Long id;
    private String destination;
    private int duration;
    private double price;
    private Long guideId;
    private Long travelPackageId;
}