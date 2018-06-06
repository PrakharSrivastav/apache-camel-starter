package routes;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.MDC;
import processors.LogContentProcessor;

public class TimerRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        MDC.put("Route", "TimerRouteBuilder");
        from("timer://simpleTimer?period=1000")
                .setBody(simple("Hello from timer at ${header.firedTime}"))
                .process(new LogContentProcessor())
                .end();
        MDC.remove("Route");
    }
}
