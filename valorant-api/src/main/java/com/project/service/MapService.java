package com.project.service;

import com.project.model.Map;
import com.project.repository.MapRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService {

    private final MapRepository mapRepository;

    public MapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    public List<Map> getAllMaps() {
        return mapRepository.findAll();
    }

    public Map getMapByUuid(String uuid) {
        return mapRepository.findByUuid(uuid);
    }

    public Map getMapByDisplayName(String displayName) {
        return mapRepository.findByDisplayName(displayName);
    }

    @Transactional
    public void deleteMapByUuid(String uuid) {
        mapRepository.deleteByUuid(uuid);
    }
}
