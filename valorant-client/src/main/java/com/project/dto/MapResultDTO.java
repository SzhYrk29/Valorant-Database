package com.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MapResultDTO(int status,
                           @JsonProperty("data") MapDTO maps) {
}
