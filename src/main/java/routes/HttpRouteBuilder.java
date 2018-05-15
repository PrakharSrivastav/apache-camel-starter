package routes;

import org.apache.camel.builder.RouteBuilder;
import processors.LogJsonContentProcessor;

public class HttpRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        //from("jetty://httpbin.org:443/ip?bridgeEndpoint=true").process(new LogJsonContentProcessor());
    }
}
