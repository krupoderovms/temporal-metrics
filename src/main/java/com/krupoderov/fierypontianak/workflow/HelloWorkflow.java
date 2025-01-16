package com.krupoderov.fierypontianak.workflow;

import com.krupoderov.fierypontianak.model.Person;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface HelloWorkflow {
  @WorkflowMethod
  String sayHello(Person person, int i);
}