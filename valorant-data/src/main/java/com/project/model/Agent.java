package com.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="agent")
public class Agent {
    @Id
    private String uuid;
    @Column(unique = true)
    private String displayName;
    @Lob
    private String description;
    private String displayIcon;
    private boolean isPlayableCharacter;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_uuid")
    @JsonManagedReference
    private Role role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agent")
    @JsonManagedReference
    private List<Ability> abilities;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public void setDisplayIcon(String displayIcon) {
        this.displayIcon = displayIcon;
    }

    public boolean isPlayableCharacter() {
        return isPlayableCharacter;
    }

    public void setPlayableCharacter(boolean playableCharacter) {
        isPlayableCharacter = playableCharacter;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
}
