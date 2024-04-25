package ua.opnu.springlab2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String language;
    private int experienceYears;

    @JsonIgnore
    @OneToMany(mappedBy = "guide", cascade = CascadeType.ALL)
    private List<Trip> trips;
}
