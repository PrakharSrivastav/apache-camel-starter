package routes;

import org.apache.camel.builder.RouteBuilder;
import processors.LogContentProcessor;

public class TimerRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        getContext().setUseMDCLogging(true);
        from("timer://simpleTimer?period=10000")
                .setBody(simple("Hello from timer at ${header.firedTime}"))
                .process(new LogContentProcessor())
                .end();
    }
}
