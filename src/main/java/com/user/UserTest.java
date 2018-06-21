package com.user;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.impl.identity.Authentication;
import org.junit.Test;

/**
 * @author lwb
 * @date 2018-6-21
 */
public class UserTest {

    @Test
    public void test0() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        IdentityService identityService = processEngine.getIdentityService();
        identityService.setAuthenticatedUserId("1");
        System.out.println("当前线程认证用户id：" + Authentication.getAuthenticatedUserId());

        new Thread(() -> {
            try {
                identityService.setAuthenticatedUserId("2");
                Thread.sleep(5000);
                System.out.println("当前线程认证用户id：" + Authentication.getAuthenticatedUserId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            identityService.setAuthenticatedUserId("3");
            System.out.println("当前线程认证用户id：" + Authentication.getAuthenticatedUserId());
        }).start();

    }

}
