package ua.opnu.springlab2.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String destination;
    private int duration;
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "guide_id")
    private Guide guide;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "package_id")
    private TravelPackage travelPackage;
}

