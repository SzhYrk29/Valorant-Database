package com.project.updater;

import com.project.ValorantClient;
import com.project.dto.AgentDTO;
import com.project.dto.AgentResultsDTO;
import com.project.dto.RoleDTO;
import com.project.mapper.AgentMapper;
import com.project.model.Agent;
import com.project.model.Role;
import com.project.repository.AgentRepository;
import com.project.repository.RoleRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Component
public class AgentUpdater {

    private static final Logger logger = LoggerFactory.getLogger(AgentUpdater.class);

    private final ValorantClient valorantClient;
    private final AgentMapper agentMapper;
    private final AgentRepository agentRepository;
    private final RoleRepository roleRepository;

    public AgentUpdater(ValorantClient valorantClient, AgentMapper agentMapper, AgentRepository agentRepository, RoleRepository roleRepository) {
        this.valorantClient = valorantClient;
        this.agentMapper = agentMapper;
        this.agentRepository = agentRepository;
        this.roleRepository = roleRepository;
    }

    public void updateRoles() {
        AgentResultsDTO agentResultsDTO = valorantClient.getAllAgents();
        List<AgentDTO> agentDTOs = agentResultsDTO.agents();

        for (AgentDTO agentDTO : agentDTOs) {
            if (agentDTO.role() != null) {
                RoleDTO roleDTO = agentDTO.role();
                if (!roleRepository.existsById(roleDTO.uuid())) {
                    try {
                        Role role = agentMapper.mapRole(roleDTO);
                        roleRepository.save(role);
                    } catch (Exception e) {
                        logger.error("Error saving role: " + roleDTO.uuid(), e);
                    }
                } else {
                    logger.info("Role already exists: " + roleDTO.uuid());
                }
            }
        }
    }

    public void updateAgents() {
        updateRoles();

        AgentResultsDTO agentResultsDTO = valorantClient.getAllAgents();
        List<AgentDTO> agentDTOs = agentResultsDTO.agents();

        List<Agent> agents = agentDTOs.stream()
                .map(agentMapper::mapAgent)
                .filter(agent -> Boolean.TRUE.equals(agent.isPlayableCharacter()))
                .toList();

        for (Agent agent : agents) {
            if (!agentRepository.existsById(agent.getUuid())) {
                try {
                    agentRepository.save(agent);
                } catch (DataIntegrityViolationException e) {
                    logger.error("Duplicate agent detected, skipping: " + agent.getUuid(), e);
                }
            }
        }
    }
}
