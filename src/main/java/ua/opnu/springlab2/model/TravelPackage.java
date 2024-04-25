package ua.opnu.springlab2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

    @JsonIgnore
    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL)
    private List<Trip> trips;
}
