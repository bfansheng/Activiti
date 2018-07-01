package com.task;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * @author lwb
 * @date 2018-7-1
 */
public class TaskVariables {


    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();

        Task task = taskService.newTask("task1");
        task.setName("申请");
        taskService.saveTask(task);

        taskService.setVariable(task.getId(), "day", 1);

    }

}
