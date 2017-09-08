package com.ztesoft.jmx.monitor.mbean.view.model;

/**
 * MBean attribute model
 */
public class MBeanAttr {
    /**
     * 属性名
     */
    private String name;

    /**
     * 属性类型
     */
    private String type;

    /**
     * 是否支持可读
     */
   private Boolean readable;
    /**
     * 是否支持可写
     */
   private Boolean writable;

    /**
     * 属性值
     */
    private String value;

    /**
     * 属相描述信息
     */
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getReadable() {
        return readable;
    }

    public void setReadable(Boolean readable) {
        this.readable = readable;
    }

    public Boolean getWritable() {
        return writable;
    }

    public void setWritable(Boolean writable) {
        this.writable = writable;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MBeanAttr{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", readable=" + readable +
                ", writable=" + writable +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
