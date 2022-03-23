import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HelloWorld {
    private static final Log log = LogFactory.getLog(HelloWorld.class);

    public static void main(String[] args) {
        log.debug("Example debug message ..");
        log.info("Example info message ..");
        log.warn("Example warn message ..");
        log.error("Example error message ..");
        log.fatal("Example fatal message ..");
    }
}
