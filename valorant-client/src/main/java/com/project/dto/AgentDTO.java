package com.project.dto;

import java.util.List;

public record AgentDTO(String uuid,
                       String displayName,
                       String description,
                       String displayIcon,
                       boolean isPlayableCharacter,
                       RoleDTO role,
                       List<AbilityDTO> abilities) {
}
