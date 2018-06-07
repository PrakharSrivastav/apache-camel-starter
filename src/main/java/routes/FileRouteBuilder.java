package routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import processors.LogContentProcessor;
import processors.LogFileContentProcessor;

public class FileRouteBuilder extends RouteBuilder {
    Logger logger = LoggerFactory.getLogger(FileRouteBuilder.class);

    @Override
    public void configure() throws Exception {
        getContext().setUseMDCLogging(Boolean.TRUE);
        from(this.fileInputURI_1(), this.fileInputURI_2())
                .routeId("fileRouteBuider")
                .log(LoggingLevel.INFO, LoggerFactory.getLogger(FileRouteBuilder.class), "marker", "Processing file ${file:name}")
//                .to("log:#logger?showAll=true&level=ERROR")
//                .log("${exchangePropertie}")
                .process(new LogFileContentProcessor())
                .process(new LogContentProcessor())
                .to(this.fileOutputURI());
    }

    private String fileInputURI_1() {
        return "file:///home/prakhar/test/input?noop=true";
    }

    private String fileInputURI_2() {
        return "file:///home/prakhar/test/input1?noop=true";
    }

    private String fileOutputURI() {
        return "file:///home/prakhar/test/output";
    }
}
