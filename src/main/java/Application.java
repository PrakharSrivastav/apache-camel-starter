import no.sysco.common.CamelApplication;
import org.apache.camel.main.Main;
import routes.FileRouteBuilder;
import routes.TimerRouteBuilder;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws Exception {
        CamelApplication application = new CamelApplication();

        // Logging properties it using method on the api.
        // Could be directly set as system properties from the command line
        Map<String, String> loggerConfig = new HashMap<>();
        loggerConfig.put("timezone", "UTC");
        loggerConfig.put("tcpDestination", "localhost:5000");
        loggerConfig.put("tcpKeepAlive", "2 minutes");
        loggerConfig.put("application", "DSF-Integration");

        application.setLoggerProperties(loggerConfig);
        boot(application);
    }


    private static void boot(final CamelApplication application) throws Exception {
        final Main main = new Main();
        main.addRouteBuilder(new FileRouteBuilder());
        main.addRouteBuilder(new TimerRouteBuilder());
        application.run(main);
    }
}
