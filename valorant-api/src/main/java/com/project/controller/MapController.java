package com.project.controller;

import com.project.model.Map;
import com.project.service.MapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping("api/maps")
    public ResponseEntity<List<Map>> getAllMaps() {
        log.info("Endpoint 'api/maps' was invoked and method 'getAllMaps' was executed.");
        return new ResponseEntity<>(mapService.getAllMaps(), HttpStatus.OK);
    }

    @GetMapping("api/maps/uuid/{uuid}")
    public ResponseEntity<Map> getMapByUuid(@PathVariable("uuid") String uuid) {
        log.info("Endpoint 'api/maps/uuid' was invoked and method 'getMapByUuid' was executed.");
        return new ResponseEntity<>(mapService.getMapByUuid(uuid), HttpStatus.OK);
    }

    @GetMapping("api/maps/name/{displayName}")
    public ResponseEntity<Map> getMapByDisplayName(@PathVariable("displayName") String displayName) {
        log.info("Endpoint 'api/maps/name' was invoked and method 'getMapByDisplayName' was executed.");
        return new ResponseEntity<>(mapService.getMapByDisplayName(displayName), HttpStatus.OK);
    }

    @DeleteMapping("api/maps/delete/{uuid}")
    public ResponseEntity<Void> deleteMapByUuid(@PathVariable("uuid") String uuid) {
        log.info("Endpoint 'api/maps/delete' was invoked and method 'deleteMapByUuid' was executed.");
        this.mapService.deleteMapByUuid(uuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
