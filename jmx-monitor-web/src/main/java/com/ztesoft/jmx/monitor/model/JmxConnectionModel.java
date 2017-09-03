package com.ztesoft.jmx.monitor.model;

/**
 * @Author: 陈名立
 * @Description:
 * @Date: 2017, 九月 03 16:03 on 星期日
 */
public class JmxConnectionModel {
    private String mode;
    private String ipAddress;
    private String port;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "JmxConnectionModel{" +
                "mode='" + mode + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
