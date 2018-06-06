package routes;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import processors.LogFileContentProcessor;

public class FileRouteBuilder extends RouteBuilder {
    Logger logger = LoggerFactory.getLogger(FileRouteBuilder.class);

    static {
        MDC.put("Route", "FileRouteBuilder");
    }

    @Override
    public void configure() throws Exception {

        from(this.fileInputURI_1(), this.fileInputURI_2())
                .log("Hello")
                .process(new LogFileContentProcessor())
                .to(this.fileOutputURI());
        MDC.remove("Route");
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
