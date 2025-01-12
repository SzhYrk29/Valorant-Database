package com.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Service
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uuid;
    private String displayName;
    private String tacticalDescription;
    private String coordinates;
    private String displayIcon;
    private String splash;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "map")
    private List<Callout> callouts;
}
