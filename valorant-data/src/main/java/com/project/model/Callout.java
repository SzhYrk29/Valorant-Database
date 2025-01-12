package com.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Service
public class Callout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String regionName;
    private String superRegionName;

    @ManyToOne
    private Map map;
}
