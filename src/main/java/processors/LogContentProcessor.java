package processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class LogContentProcessor implements Processor {

    static Logger logger = LoggerFactory.getLogger(LogContentProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        MDC.put("Processor", "LogContentProcessor");
        logger.info(exchange.getIn().getBody().toString());
        MDC.remove("Processor");
    }
}
