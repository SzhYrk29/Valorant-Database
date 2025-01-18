package com.project;

import com.project.updater.AgentUpdater;
import com.project.updater.MapUpdater;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = "com.project")
public class ValorantUpdaterApplication implements CommandLineRunner {

    private final MapUpdater mapUpdater;
    private final AgentUpdater agentUpdater;

    public ValorantUpdaterApplication(MapUpdater mapUpdater, AgentUpdater agentUpdater) {
        this.mapUpdater = mapUpdater;
        this.agentUpdater = agentUpdater;
    }

    public static void main(String[] args) {
        SpringApplication.run(ValorantUpdaterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mapUpdater.updateMaps();
        agentUpdater.updateAgents();
    }
}