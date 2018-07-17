package processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class LogFileContentProcessor implements Processor {


    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody(exchange.getIn().getBody());
        exchange.getIn().setHeaders(exchange.getIn().getHeaders());
    }
}
