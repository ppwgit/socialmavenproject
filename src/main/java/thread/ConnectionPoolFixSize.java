package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPoolFixSize {
    private static final int POOL_SIZE = 5;

    private static ConnectionPoolFixSize instance;
    private BlockingQueue<Connection> pool;

    private ConnectionPoolFixSize() {
        pool = new LinkedBlockingQueue<>(POOL_SIZE);
        initializePool();
    }

    public static synchronized ConnectionPoolFixSize getInstance() {
        if (instance == null) {
            instance = new ConnectionPoolFixSize();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            return pool.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            pool.offer(connection);
        }
    }

    private void initializePool() {
        for (int i = 0; i < POOL_SIZE; i++) {
            pool.offer(createConnection());
        }
    }

    private Connection createConnection() {
        return new Connection("jdbc:mysql://localhost:3306/solvdlab", "username", "password");
    }
}
