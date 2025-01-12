package com.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MapResultsDTO(int status,
                            @JsonProperty("data") List<MapDTO> maps) {
}
