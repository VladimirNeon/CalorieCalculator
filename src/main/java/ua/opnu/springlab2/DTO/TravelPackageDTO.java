package ua.opnu.springlab2.DTO;

import lombok.Data;
import java.util.Date;

@Data
public class TravelPackageDTO {
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
}
