package com.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AgentResultDTO(@JsonProperty("data") AgentDTO agent) {
}
