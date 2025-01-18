package com.project.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="map")
public class Map {
    @Id
    private String uuid;
    private String displayName;
    private String tacticalDescription;
    private String coordinates;
    private String displayIcon;
    private String splash;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "map")
    private List<Callout> callouts = new ArrayList<>();

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

    public String getTacticalDescription() {
        return tacticalDescription;
    }

    public void setTacticalDescription(String tacticalDescription) {
        this.tacticalDescription = tacticalDescription;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public void setDisplayIcon(String displayIcon) {
        this.displayIcon = displayIcon;
    }

    public String getSplash() {
        return splash;
    }

    public void setSplash(String splash) {
        this.splash = splash;
    }

    public List<Callout> getCallouts() {
        return callouts;
    }

    public void setCallouts(List<Callout> callouts) {
        this.callouts = callouts;
    }
}
