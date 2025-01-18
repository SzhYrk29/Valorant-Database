package com.project.repository;

import com.project.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, String> {
    Agent findByUuid(String uuid);
    Agent findByDisplayName(String displayName);
    void deleteByUuid(String uuid);
}
