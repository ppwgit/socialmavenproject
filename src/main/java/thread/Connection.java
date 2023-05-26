package thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {
    private static final Logger logger = LogManager.getLogger(Connection.class);
    private String datasourceurl;
    private String username;
    private String password;

    public Connection(String datasourceurl, String username, String password) {
        this.datasourceurl = datasourceurl;
        this.username = username;
        this.password = password;
    }

    public void connect() {
        logger.info("Connected to the database");
    }

    public void disconnect() {
        logger.info("Disconnected from the database");
    }
}