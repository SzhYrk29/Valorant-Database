package com.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AgentResultsDTO(int status,
                              @JsonProperty("data") List<AgentDTO> agents) {
}
