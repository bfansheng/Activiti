package com.create;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lwb
 * @date 2018-6-14
 */
public class BuildProcessEngine {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuildProcessEngine.class);

    @Test
    public void test0() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        ProcessEngine processEngine = configuration.buildProcessEngine();
        LOGGER.info("引擎名称：{}", processEngine.getName());
        processEngine.close();
    }

}
