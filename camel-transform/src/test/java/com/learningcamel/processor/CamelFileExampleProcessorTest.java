package com.learningcamel.processor;

import com.learningcamel.routes.CamelModifyFileProcessorRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelFileExampleProcessorTest extends CamelTestSupport {
    @Override
    public RouteBuilder createRouteBuilder() {
        return new CamelModifyFileProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {
        String expectedValue = "123:test:06APR2018\n";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expectedValue);

        Thread.sleep(5000);

        File file = new File("data/output");
        assertTrue(file.isDirectory());
        assertMockEndpointsSatisfied();
    }
}