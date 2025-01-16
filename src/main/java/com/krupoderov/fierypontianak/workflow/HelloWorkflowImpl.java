package com.krupoderov.fierypontianak.workflow;

import com.krupoderov.fierypontianak.activity.HelloActivity;
import com.krupoderov.fierypontianak.model.Person;
import io.temporal.activity.ActivityOptions;
import io.temporal.spring.boot.WorkflowImpl;
import io.temporal.workflow.Workflow;

import java.time.Duration;

@WorkflowImpl(taskQueues = "HelloSampleTaskQueue")
public class HelloWorkflowImpl implements HelloWorkflow {

    private final HelloActivity activity =
            Workflow.newActivityStub(
                    HelloActivity.class,
                    ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(2)).build());

    @Override
    public String sayHello(Person person, int i) {
        if (i == 1) {
            throw new RuntimeException();
        }
        return activity.hello(person);
    }
}