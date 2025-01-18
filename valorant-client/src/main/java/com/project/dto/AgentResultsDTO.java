package com.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AgentResultsDTO(@JsonProperty("data") List<AgentDTO> agents) {
}
