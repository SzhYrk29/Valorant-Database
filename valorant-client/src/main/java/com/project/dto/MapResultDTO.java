package com.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MapResultDTO(@JsonProperty("data") MapDTO map) {
}
