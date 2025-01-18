package com.project.service;

import com.project.model.Agent;
import com.project.repository.AgentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {
    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Agent getAgentByUuid(String uuid) {
        return agentRepository.findByUuid(uuid);
    }

    public Agent getAgentByDisplayName(String displayName) {
        return agentRepository.findByDisplayName(displayName);
    }

    @Transactional
    public void deleteAgentByUuid(String uuid) {
        agentRepository.deleteByUuid(uuid);
    }
}
