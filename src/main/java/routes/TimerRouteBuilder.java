package routes;

import org.apache.camel.builder.RouteBuilder;
import processors.LogContentProcessor;

public class TimerRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer://simpleTimer?period=1000")
                .setBody(simple("Hello from timer at ${header.firedTime}"))
                .process(new LogContentProcessor())
                .end();
    }
}
