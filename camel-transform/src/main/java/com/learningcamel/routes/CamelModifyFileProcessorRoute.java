package com.learningcamel.routes;

import com.learningcamel.processor.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileProcessorRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .log("Received file is ${body} and headers are ${headers}")
                .process(new CamelFileExampleProcessor())
                .to("file:data/output?fileName=output.txt")
                .to("mock:output");
    }
}
