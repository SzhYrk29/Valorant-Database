package com.project.controller;

import com.project.model.Agent;
import com.project.service.AgentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController

public class AgentController {
    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping("api/agents")
    public ResponseEntity<List<Agent>> getAllAgents() {
        log.info("Endpoint 'api/agents' was invoked and method 'getAllAgents' was executed.");
        return new ResponseEntity<>(agentService.getAllAgents(), HttpStatus.OK);
    }

    @GetMapping("api/agents/uuid/{uuid}")
    public ResponseEntity<Agent> getAgentByUuid(@PathVariable("uuid") String uuid) {
        log.info("Endpoint 'api/agents/uuid' was invoked and method 'getAgentByUuid' was executed.");
        return new ResponseEntity<>(agentService.getAgentByUuid(uuid), HttpStatus.OK);
    }

    @GetMapping("api/agents/name/{displayName}")
    public ResponseEntity<Agent> getAgentByDisplayName(@PathVariable("displayName") String displayName) {
        log.info("Endpoint 'api/agents/name' was invoked and method 'getAgentByDisplayName' was executed.");
        return new ResponseEntity<>(agentService.getAgentByDisplayName(displayName), HttpStatus.OK);
    }

    @DeleteMapping("api/agents/delete/{uuid}")
    public ResponseEntity<Void> deleteAgentByUuid(@PathVariable("uuid") String uuid) {
        log.info("Endpoint 'api/agents/delete' was invoked and method 'deleteAgentByUuid' was executed.");
        agentService.deleteAgentByUuid(uuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
