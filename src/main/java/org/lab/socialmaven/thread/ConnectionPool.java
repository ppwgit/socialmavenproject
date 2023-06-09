package org.lab.socialmaven.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static final int MAX_POOL_SIZE = 10;
    private static final int INITIAL_POOL_SIZE = 5;

    private static ConnectionPool instance;
    private BlockingQueue<Connection> pool;

    private ConnectionPool() {
        pool = new LinkedBlockingQueue<>(MAX_POOL_SIZE);
        initializePool();
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() {
        if (pool == null || pool.isEmpty()) {
            initializePool();
        }
        return pool.poll();
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            pool.offer(connection);
        }
    }

    private void initializePool() {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.offer(createConnection());
        }
    }

    private Connection createConnection() {
        return new Connection("jdbc:mysql://localhost:3306/solvdlab", "username", "password");
    }
}
