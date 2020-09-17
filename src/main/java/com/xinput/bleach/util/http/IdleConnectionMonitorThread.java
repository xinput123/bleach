package com.xinput.bleach.util.http;

import com.xinput.bleach.util.Logs;
import org.apache.http.conn.HttpClientConnectionManager;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * 连接处理,释放连接池连接
 */
public class IdleConnectionMonitorThread extends Thread {

    private static final Logger logger = Logs.get();

    private final HttpClientConnectionManager connMgr;
    private volatile boolean shutdown;

    public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
        super();
        this.connMgr = connMgr;
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    // Close expired connections
                    connMgr.closeExpiredConnections();
                    // Optionally, close connections
                    // that have been idle longer than 30 sec
                    connMgr.closeIdleConnections(30, TimeUnit.SECONDS);
                }
            }
        } catch (InterruptedException e) {
            logger.error("释放连接池连接出错.", e);
        }
    }

    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }

}
