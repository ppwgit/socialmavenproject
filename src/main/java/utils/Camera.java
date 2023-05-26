package utils;

import exception.CameraFailedtoConnectException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class Camera implements AutoCloseable {
    private static final Logger logger = LogManager.getLogger(Camera.class);
    private String ipAddress;
    private boolean connected;


    public Camera(String ipAddress) {
        this.ipAddress = ipAddress;
        this.connected = false;
    }

    public void connect() throws IOException, CameraFailedtoConnectException {

    }

    public void startStreaming() {
        logger.debug("start streaming ");
    }

    public void disconnect() {
        logger.debug("disconnect Camera ");
        connected = false;
    }

    public void close() throws IOException {
        disconnect();
    }
}
