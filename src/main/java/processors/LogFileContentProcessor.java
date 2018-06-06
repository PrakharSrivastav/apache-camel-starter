package processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.slf4j.MDC;

import java.io.*;

public class LogFileContentProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        MDC.put("Processor", "LogFileContentProcessor");
        this.logFileContents((GenericFile<File>) exchange.getIn().getBody());
        exchange.getIn().setBody(exchange.getIn().getBody());
        exchange.getIn().setHeaders(exchange.getIn().getHeaders());
        MDC.remove("Processor");
    }

    private void logFileContents(final GenericFile<File> file) {

        try {
            StringBuilder sb = new StringBuilder();
            if (file != null) {
                FileReader fr = new FileReader(file.getFile());
                BufferedReader br = new BufferedReader(fr);
                String tmp;
                while ((tmp = br.readLine()) != null) {
                    System.out.println(tmp);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
