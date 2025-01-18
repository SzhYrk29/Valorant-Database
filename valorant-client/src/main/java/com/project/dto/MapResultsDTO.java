package com.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MapResultsDTO(@JsonProperty("data") List<MapDTO> maps) {
}
