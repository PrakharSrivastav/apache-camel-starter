package processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogContentProcessor implements Processor {

    static Logger logger = LoggerFactory.getLogger(LogContentProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("The logger conetent is {}", "Yo");
//        throw new IllegalArgumentException("Some error");
    }
}
