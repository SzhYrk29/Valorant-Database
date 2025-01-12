package com.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AgentResultDTO(int status,
                             @JsonProperty("data") AgentDTO agents) {
}
