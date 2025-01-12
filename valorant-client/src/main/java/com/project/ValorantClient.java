package com.project;

import com.project.dto.AgentResultDTO;
import com.project.dto.AgentResultsDTO;
import com.project.dto.MapResultDTO;
import com.project.dto.MapResultsDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@AllArgsConstructor
public class ValorantClient {
    private final RestClient restClient;

    public AgentResultsDTO getAllAgents() {

        String url = "https://valorant-api.com/v1/agents";

        return restClient
                .get()
                .uri(url)
                .retrieve()
                .body(AgentResultsDTO.class);
    }

    public AgentResultDTO getAgentByUuid(String uuid) {

        String url = "https://valorant-api.com/v1/agents/" + uuid;

        return restClient
                .get()
                .uri(url)
                .retrieve()
                .body(AgentResultDTO.class);
    }

    public MapResultsDTO getAllMaps() {

        String url = "https://valorant-api.com/v1/maps";

        return restClient
                .get()
                .uri(url)
                .retrieve()
                .body(MapResultsDTO.class);
    }

    public MapResultDTO getMapByUuid(String uuid) {

        String url = "https://valorant-api.com/v1/maps/" + uuid;

        return restClient
                .get()
                .uri(url)
                .retrieve()
                .body(MapResultDTO.class);
    }
}
