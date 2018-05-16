import org.apache.camel.main.Main;
import org.apache.camel.main.MainListenerSupport;
import org.apache.camel.main.MainSupport;
import routes.FileRouteBuilder;
import routes.TimerRouteBuilder;

import static java.lang.System.out;

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
        main.addRouteBuilder(new TimerRouteBuilder());
        main.run();
    }


    private static class Events extends MainListenerSupport {

        @Override
        public void afterStart(final MainSupport main) {
            out.println("Camel app is now started!");
        }

        @Override
        public void beforeStop(final MainSupport main) {
            out.println("Camel app is shutting down!");
        }
    }
}
