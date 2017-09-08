package com.ztesoft.jmx.monitor.mbean.view.dto;

import com.ztesoft.jmx.monitor.mbean.view.model.MBeanAttr;
import com.ztesoft.jmx.monitor.mbean.view.model.MBeanOperation;

import java.util.List;

/**
 * 单个 mBean 的详细信息
 */
public class MBeanDTO {
    /**
     * mbean name
     */
    private String mbeanName;

    /**
     * mbean class
     */
    private String mbeanClass;

    /**
     * mbean description
     */
    private String mbeanDescription;

    /**
     * mbean 所处状态
     * TODO 已注册,取消注册
     */
    private int state;

    /**
     * 包含的属性列表
     */
    private List<MBeanAttr> mBeanAttrList;

    /**
     * 包含的属性操作
     */
    private List<MBeanOperation> mBeanOperationList;

    public String getMbeanName() {
        return mbeanName;
    }

    public void setMbeanName(String mbeanName) {
        this.mbeanName = mbeanName;
    }

    public String getMbeanClass() {
        return mbeanClass;
    }

    public void setMbeanClass(String mbeanClass) {
        this.mbeanClass = mbeanClass;
    }

    public String getMbeanDescription() {
        return mbeanDescription;
    }

    public void setMbeanDescription(String mbeanDescription) {
        this.mbeanDescription = mbeanDescription;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<MBeanAttr> getmBeanAttrList() {
        return mBeanAttrList;
    }

    public void setmBeanAttrList(List<MBeanAttr> mBeanAttrList) {
        this.mBeanAttrList = mBeanAttrList;
    }

    public List<MBeanOperation> getmBeanOperationList() {
        return mBeanOperationList;
    }

    public void setmBeanOperationList(List<MBeanOperation> mBeanOperationList) {
        this.mBeanOperationList = mBeanOperationList;
    }

    @Override
    public String toString() {
        return "MBeanDTO{" +
                "mbeanName='" + mbeanName + '\'' +
                ", mbeanClass='" + mbeanClass + '\'' +
                ", mbeanDescription='" + mbeanDescription + '\'' +
                ", state=" + state +
                ", mBeanAttrList=" + mBeanAttrList +
                ", mBeanOperationList=" + mBeanOperationList +
                '}';
    }
}
