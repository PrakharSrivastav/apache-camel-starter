import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;
import org.apache.camel.main.MainListenerSupport;
import org.apache.camel.main.MainSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import routes.FileRouteBuilder;
import routes.HttpRouteBuilder;

import java.util.Date;

public class Application {

    private Main main;

    public static void main(String[] args) throws Exception {
        Application application = new Application();
        application.boot();
    }


    private void boot() throws Exception {
        main = new Main();
        main.addMainListener(new Events());
        main.addRouteBuilder(new FileRouteBuilder());
        main.addRouteBuilder(new HttpRouteBuilder());
        main.run();
    }


    private static class Events extends MainListenerSupport {

        @Override
        public void afterStart(final MainSupport main) {
            System.out.println("MainExample with Camel is now started!");
        }

        @Override
        public void beforeStop(final MainSupport main) {
            System.out.println("MainExample with Camel is now being stopped!");
        }
    }
}
