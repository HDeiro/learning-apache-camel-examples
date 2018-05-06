package com.learningcamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CamelFileExampleProcessor implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {
        System.out.println("Exchange in Processor is: " + exchange.getIn().getBody());

        GenericFile<File> file = (GenericFile<File>) exchange.getIn().getBody();

        if(file != null) {
            String readLine = null;
            String newValue = "";
            FileReader fileReader = new FileReader(file.getFile());
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((readLine = bufferedReader.readLine()) != null) {
                System.out.println("Read Line is: " + readLine);
                String oldValue = readLine;
                newValue += oldValue.replace(',', ':') + "\n";
            }

            exchange.getIn().setBody(newValue);
        }
    }
}