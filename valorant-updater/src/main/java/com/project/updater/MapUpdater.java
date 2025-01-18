package com.project.updater;

import com.project.ValorantClient;
import com.project.dto.MapDTO;
import com.project.dto.MapResultsDTO;
import com.project.mapper.MapMapper;
import com.project.model.Map;
import com.project.repository.MapRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapUpdater {

    private final ValorantClient valorantClient;
    private final MapMapper mapMapper;
    private final MapRepository mapRepository;

    public MapUpdater(ValorantClient valorantClient, MapMapper mapMapper, MapRepository mapRepository) {
        this.valorantClient = valorantClient;
        this.mapMapper = mapMapper;
        this.mapRepository = mapRepository;
    }

    public void updateMaps() {
        MapResultsDTO mapResultsDTO = valorantClient.getAllMaps();

        List<MapDTO> mapDTOs = mapResultsDTO.maps();

        List<Map> maps = mapDTOs.stream()
                .map(mapMapper::mapMap)
                .toList();

        mapRepository.saveAll(maps);
    }
}
