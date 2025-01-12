package com.project.dto;

import java.util.List;

public record MapDTO(String uuid,
                     String displayName,
                     String tacticalDescription,
                     String coordinates,
                     String displayIcon,
                     String splash,
                     List<CalloutDTO> callouts) {
}
