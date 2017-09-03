package com.ztesoft.jmx.monitor.model;

/**
 * @Author: 陈名立
 * @Description:
 * @Date: 2017, 九月 03 15:57 on 星期日
 */
public class JmxConnectionMsgModel {
    private String code;
    private String msg;

    public JmxConnectionMsgModel() {
    }

    public JmxConnectionMsgModel(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
