import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 18.12.16.
 */
public class Logger {

    private static List<String> log = new ArrayList<String>();

    public static void log(LogEntries logEntries) {
        for (LogEntry logEntry : logEntries) {
            log.add(logEntry.getLevel().toString());
        }
    }

    public static List<String> getMessages() {
        return log;
    }
}
