package com.repository.starterUser;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;

import java.io.InputStream;

/**
 * @author lwb
 * @date 2018-6-25
 */
public class StarterUser {

    public static void main(String[] args) throws Exception {
        // 创建流程引擎
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 得到流程存储服务实例
        RepositoryService repositoryService = engine.getRepositoryService();

        Deployment deploy = repositoryService.createDeployment().addClasspathResource("artifact/candidateGroup.bpmn").deploy();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();

        System.out.println(processDefinition.getId());
        repositoryService.addCandidateStarterGroup(processDefinition.getId(), "groupId");
        repositoryService.addCandidateStarterUser(processDefinition.getId(), "userId");
    }

}
