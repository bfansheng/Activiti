package com.group;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

/**
 * @author lwb
 * @date 2018-6-21
 */
public class GroupTest {

    @Test
    public void createGroup() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        IdentityService identityService = engine.getIdentityService();
        String genId = UUID.randomUUID().toString();
        Group group = identityService.newGroup(genId);
        group.setName("开发");
        group.setType("developer");
        // 让activiti自动生成主键
        //group.setId(null);
        identityService.saveGroup(group);

        Group group1 = identityService.createGroupQuery().groupId(genId).singleResult();
        group1.setName("开发2");
        identityService.saveGroup(group1);
        System.out.println("Group ID:" + group1.getId() + ",name:" + group1.getName());
    }

    @Test
    public void query() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        IdentityService identityService = engine.getIdentityService();
        List<Group> list = identityService.createNativeGroupQuery().sql("select * from act_id_group").list();
        for (Group group : list) {
            System.out.println(group.getName());
        }
    }

}
