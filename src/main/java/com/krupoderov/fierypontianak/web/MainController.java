package com.krupoderov.fierypontianak.web;

//import com.krupoderov.fierypontianak.WorkflowClientService;
import com.krupoderov.fierypontianak.model.Person;
import com.krupoderov.fierypontianak.workflow.HelloWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {

    private final WorkflowClient client;

    public MainController(WorkflowClient client) {
        this.client = client;
    }

//    public MainController(WorkflowClientService workflowClientService) {
//        this.workflowClientService = workflowClientService;
//    }

    @GetMapping("/")
    public String getHello() {
        return "Hello!";
    }

    @PostMapping("/hello")
    public String helloSample(@RequestBody Person person) {
        var workflow =
                client
                        .newWorkflowStub(
                                HelloWorkflow.class,
                                WorkflowOptions.newBuilder()
                                        .setTaskQueue("HelloSampleTaskQueue")
                                        .setWorkflowId("HelloSample")
                                        .build());

        // bypass thymeleaf, don't return template name just result
        return workflow.sayHello(person, 0);
    }

    @GetMapping("/error")
    public String error() {
        var workflow =
                client
                        .newWorkflowStub(
                                HelloWorkflow.class,
                                WorkflowOptions.newBuilder()
                                        .setTaskQueue("HelloSampleTaskQueue")
                                        .setWorkflowId("HelloSample")
                                        .build());

        return workflow.sayHello(new Person("1", "2"), 1);
    }
}
