//package com.krupoderov.fierypontianak;
//
//import com.uber.m3.tally.RootScopeBuilder;
//import com.uber.m3.tally.Scope;
//import com.uber.m3.util.ImmutableMap;
//import io.micrometer.prometheus.PrometheusConfig;
//import io.micrometer.prometheus.PrometheusMeterRegistry;
//import io.temporal.client.WorkflowClient;
//import io.temporal.common.reporter.MicrometerClientStatsReporter;
//import io.temporal.serviceclient.WorkflowServiceStubs;
//import io.temporal.serviceclient.WorkflowServiceStubsOptions;
//import org.springframework.stereotype.Component;
//
//@Component
//public class WorkflowClientService {
//
//    public WorkflowClient getClient() {
//        // Set up prometheus registry and stats reported
//        var registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
//        // Set up a new scope, report every 1 second
//        var scope =
//                new RootScopeBuilder()
//                        // shows how to set custom tags
//                        .tags(
//                                ImmutableMap.of(
//                                        "workerCustomTag1",
//                                        "workerCustomTag1Value",
//                                        "workerCustomTag2",
//                                        "workerCustomTag2Value"))
//                        .reporter(new MicrometerClientStatsReporter(registry))
//                        .reportEvery(com.uber.m3.util.Duration.ofSeconds(1));
//
//        WorkflowServiceStubsOptions stubOptions =
//                WorkflowServiceStubsOptions.newBuilder()
//                        .setMetricsScope(scope).build();
//
//        var service = WorkflowServiceStubs.newServiceStubs(stubOptions);
//
//        return WorkflowClient.newInstance(service);
//    }
//}
