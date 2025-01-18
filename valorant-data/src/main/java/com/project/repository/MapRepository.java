package com.project.repository;

import com.project.model.Map;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<Map, String> {
    Map findByUuid(String uuid);
    Map findByDisplayName(String displayName);
    void deleteByUuid(String uuid);
}
