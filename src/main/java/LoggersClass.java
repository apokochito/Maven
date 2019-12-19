import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggersClass {

    // LOG4j
    private static final Logger log4j =  LogManager.getLogger(LoggersClass.class);

    // SLF4J
    private static final org.slf4j.Logger slf4j = LoggerFactory.getLogger(LoggersClass.class);

    public void getInfoLoggers(){
        log4j.info("This is a INFO log using LOG4J library");
        slf4j.info("This is a INFO log using SLF4J library");
    }

    // You can also use annotations for this loggers.

}
