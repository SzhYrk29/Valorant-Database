package com.project.scheduler;

import com.project.updater.AgentUpdater;
import com.project.updater.MapUpdater;
import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdaterJob implements Job {

    private final AgentUpdater agentUpdater;
    private final MapUpdater mapUpdater;

    private static final Logger logger = LoggerFactory.getLogger(UpdaterJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        agentUpdater.updateRoles();
        logger.info("Updating roles");
        agentUpdater.updateAgents();
        logger.info("Updating agents");
        mapUpdater.updateMaps();
        logger.info("Updating maps");
    }
}
