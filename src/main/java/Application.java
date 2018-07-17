import no.sysco.common.CamelApplication;
import org.apache.camel.main.Main;
import routes.FileRouteBuilder;
import routes.TimerRouteBuilder;

import java.util.HashMap;
import java.util.Map;

public final class Application {

    public static void main(String[] args) throws Exception {

        // Logging properties it using method on the api.
        // Could be directly set as system properties from the command line
        Map<String, String> loggerConfig = new HashMap<>();
        loggerConfig.put("timezone", "UTC");
        loggerConfig.put("streamToLogstash", "false");
        loggerConfig.put("streamToFile", "false");
        loggerConfig.put("streamToElasticSearch", "false");
        loggerConfig.put("application", "DSF-Integration");

        CamelApplication.setLoggerProperties(loggerConfig);
        Application.boot();
    }


    private static void boot() throws Exception {
        final Main main = new Main();
        main.addRouteBuilder(new FileRouteBuilder());
        main.addRouteBuilder(new TimerRouteBuilder());
        CamelApplication.run(main);
    }
}
