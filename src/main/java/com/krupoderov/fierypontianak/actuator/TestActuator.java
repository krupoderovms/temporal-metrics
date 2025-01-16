//package com.krupoderov.fierypontianak.actuator;
//
//import io.temporal.spring.boot.autoconfigure.template.WorkersTemplate;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
//import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
//import org.springframework.stereotype.Component;
//
//@Component
////@Endpoint(id = "temporal_metrics")
//@Endpoint(id = "metrics")
//public class TestActuator {
//
//    private final WorkersTemplate workersTemplate;
//
//    public TestActuator(@Qualifier("temporalWorkersTemplate") WorkersTemplate workersTemplate) {
//        this.workersTemplate = workersTemplate;
//    }
//
//    @ReadOperation
//    public String info() {
//
//
//        return null;
//    }
//}
