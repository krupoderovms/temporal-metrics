//package com.krupoderov.fierypontianak;
//
//import com.krupoderov.fierypontianak.activity.HelloActivityImpl;
//import com.krupoderov.fierypontianak.workflow.HelloWorkflow;
//import com.krupoderov.fierypontianak.workflow.HelloWorkflowImpl;
//import com.sun.net.httpserver.HttpServer;
//import com.uber.m3.tally.RootScopeBuilder;
//import com.uber.m3.tally.Scope;
//import com.uber.m3.util.ImmutableMap;
//import io.micrometer.*;
//import io.micrometer.prometheus.PrometheusMeterRegistry;
//import io.temporal.client.WorkflowClient;
//import io.temporal.common.reporter.MicrometerClientStatsReporter;
//import io.temporal.serviceclient.WorkflowServiceStubs;
//import io.temporal.serviceclient.WorkflowServiceStubsOptions;
//import io.temporal.worker.Worker;
//import io.temporal.worker.WorkerFactory;
//import io.temporal.worker.WorkflowImplementationOptions;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MetricsWorker {
//
//  // task queue to be used for this sample
//  public static final String DEFAULT_TASK_QUEUE_NAME = "metricsqueue";
//
////  public static void main(String[] args) {
//  public void info() {
//
//    // Set up prometheus registry and stats reported
//    PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
//    // Set up a new scope, report every 1 second
//    Scope scope =
//        new RootScopeBuilder()
//            // shows how to set custom tags
//            .tags(
//                ImmutableMap.of(
//                    "workerCustomTag1",
//                    "workerCustomTag1Value",
//                    "workerCustomTag2",
//                    "workerCustomTag2Value"))
//            .reporter(new MicrometerClientStatsReporter(registry))
//            .reportEvery(com.uber.m3.util.Duration.ofSeconds(1));
//    // Start the prometheus scrape endpoint
//    HttpServer scrapeEndpoint = MetricsUtils.startPrometheusScrapeEndpoint(registry, 8077);
//    // Stopping the worker will stop the http server that exposes the
//    // scrape endpoint.
//    Runtime.getRuntime().addShutdownHook(new Thread(() -> scrapeEndpoint.stop(1)));
//    // Add metrics scope to workflow service stub options
//    WorkflowServiceStubsOptions stubOptions =
//        WorkflowServiceStubsOptions.newBuilder()
//                .setMetricsScope(scope).build();
//
//    WorkflowServiceStubs service = WorkflowServiceStubs.newInstance(stubOptions);
//    WorkflowClient client = WorkflowClient.newInstance(service);
//    WorkerFactory factory = WorkerFactory.newInstance(client);
//
//    Worker worker = factory.newWorker(DEFAULT_TASK_QUEUE_NAME);
//
//    WorkflowImplementationOptions options = WorkflowImplementationOptions.newBuilder()
//            .setFailWorkflowExceptionTypes(IllegalArgumentException.class)
//            .build();
//
//    worker.registerWorkflowImplementationTypes(HelloWorkflowImpl.class);
//    worker.registerActivitiesImplementations(new HelloActivityImpl());
//
//    factory.start();
//
//    System.out.println("Workers metrics are available at http://localhost:8077/metrics");
//  }
//}