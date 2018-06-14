package com.create;

import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author lwb
 * @date 2018-6-14
 */
public class ReadConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadConfig.class);

    @Test
    public void test0() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        logInfo(configuration.getProcessEngineName());
    }

    @Test
    public void test1() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        logInfo(configuration.getProcessEngineName());
    }

    @Test
    public void test2() throws FileNotFoundException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("activiti.cfg.xml");
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromInputStream(is);
        logInfo(configuration.getProcessEngineName());
    }

    private void logInfo(String info) {
        LOGGER.info("流程引擎名称：{}", info);
    }

}
