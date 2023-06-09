package org.lab.socialmaven.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionTask implements Runnable {
    private static final Logger logger = LogManager.getLogger(ConnectionTask.class);
    private ConnectionPoolFixSize connectionPoolFixsize;

    public ConnectionTask(ConnectionPoolFixSize connectionPoolFixsize) {
        this.connectionPoolFixsize = connectionPoolFixsize;
    }

    public void run() {
        Connection connection = connectionPoolFixsize.getConnection();
        if (connection != null) {
            connection.connect();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            connection.disconnect();
            connectionPoolFixsize.releaseConnection(connection);
        } else {
            logger.info("Full connections. Wait");
        }
    }
}