package com.project.mapper;

import com.project.dto.AbilityDTO;
import com.project.dto.AgentDTO;
import com.project.dto.RoleDTO;
import com.project.model.Ability;
import com.project.model.Agent;
import com.project.model.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AgentMapper {
    public Agent mapAgent(AgentDTO agentDTO) {
        Agent agent = new Agent();
        agent.setUuid(agentDTO.uuid());
        agent.setDisplayName(agentDTO.displayName());
        agent.setDescription(agentDTO.description());
        agent.setDisplayIcon(agentDTO.displayIcon());
        agent.setPlayableCharacter(agentDTO.isPlayableCharacter());

        if (agentDTO.role() != null) {
            agent.setRole(mapRole(agentDTO.role()));
        }

        List<AbilityDTO> abilityDTOS = agentDTO.abilities() != null ? agentDTO.abilities() : List.of();
        List<Ability> abilities = new ArrayList<>();
        for (AbilityDTO abilityDTO : abilityDTOS) {
            abilities.add(mapAbility(abilityDTO, agent));
        }
        agent.setAbilities(abilities);
        return agent;
    }

    public Role mapRole(RoleDTO roleDTO) {
        if (roleDTO == null) {
            return null;
        }

        Role role = new Role();
        role.setUuid(roleDTO.uuid());
        role.setDisplayName(roleDTO.displayName());
        role.setDescription(roleDTO.description());
        role.setDisplayIcon(roleDTO.displayIcon());
        return role;
    }

    public Ability mapAbility(AbilityDTO abilityDTO, Agent agent) {
        Ability ability = new Ability();
        ability.setSlot(abilityDTO.slot());
        ability.setDisplayName(abilityDTO.displayName());
        ability.setDescription(abilityDTO.description());
        ability.setDisplayIcon(abilityDTO.displayIcon());
        ability.setAgent(agent);
        return ability;
    }
}
