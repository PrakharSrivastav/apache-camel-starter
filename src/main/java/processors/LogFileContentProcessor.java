package processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class LogFileContentProcessor implements Processor {

    private Logger logger = LoggerFactory.getLogger(LogContentProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
//        this.logFileContents((GenericFile<File>) exchange.getIn().getBody());
        exchange.getIn().setBody(exchange.getIn().getBody());
        exchange.getIn().setHeaders(exchange.getIn().getHeaders());
    }

    private void logFileContents(final GenericFile<File> file) {
        try {
            StringBuilder sb = new StringBuilder();
            if (file != null) {
                FileReader fr = new FileReader(file.getFile());
                BufferedReader br = new BufferedReader(fr);
                String tmp;
                while ((tmp = br.readLine()) != null) {
                    this.logger.info(tmp);
                }
            }
        } catch (FileNotFoundException e) {
            this.logger.error("Exception", e);
            e.printStackTrace();
        } catch (IOException e) {
            this.logger.error("Exception", e);
            e.printStackTrace();
        }
    }
}
