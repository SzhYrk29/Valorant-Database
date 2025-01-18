package com.project.controller;

import com.project.model.Agent;
import com.project.service.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AgentController {
    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping("api/agents")
    public ResponseEntity<List<Agent>> getAllAgents() {
        return new ResponseEntity<>(agentService.getAllAgents(), HttpStatus.OK);
    }

    @GetMapping("api/agents/uuid/{uuid}")
    public ResponseEntity<Agent> getAgentByUuid(@PathVariable("uuid") String uuid) {
        return new ResponseEntity<>(agentService.getAgentByUuid(uuid), HttpStatus.OK);
    }

    @GetMapping("api/agents/name/{displayName}")
    public ResponseEntity<Agent> getAgentByDisplayName(@PathVariable("displayName") String displayName) {
        return new ResponseEntity<>(agentService.getAgentByDisplayName(displayName), HttpStatus.OK);
    }

    @DeleteMapping("api/agents/delete/{uuid}")
    public ResponseEntity<Void> deleteAgentByUuid(@PathVariable("uuid") String uuid) {
        agentService.deleteAgentByUuid(uuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
