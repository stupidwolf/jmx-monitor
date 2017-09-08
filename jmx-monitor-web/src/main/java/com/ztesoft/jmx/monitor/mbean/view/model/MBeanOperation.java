package com.ztesoft.jmx.monitor.mbean.view.model;

import java.util.List;

/**
 * MBean operation model.
 */
public class MBeanOperation {
    /**
     * 方法返回值
     */
    private String returnType;

    /**
     * 方法名
     */
    private String operationName;

    /**
     * 参数列表
     */
    private List<OperationArg> args;

    /**
     * 方法描述
     */
    private String description;

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public List<OperationArg> getArgs() {
        return args;
    }

    public void setArgs(List<OperationArg> args) {
        this.args = args;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MBeanOperation{" +
                "returnType='" + returnType + '\'' +
                ", operationName='" + operationName + '\'' +
                ", args=" + args +
                ", description='" + description + '\'' +
                '}';
    }
}
