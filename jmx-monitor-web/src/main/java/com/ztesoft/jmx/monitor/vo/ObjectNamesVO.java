package com.ztesoft.jmx.monitor.vo;

import javax.management.ObjectName;
import java.io.Serializable;
import java.util.*;

/**
 * 用于展示 Agent View 中的 ObjectName 信息
 */
public class ObjectNamesVO implements Serializable{
    private static final long serialVersionUID = 8054547305391301894L;

    /**
     * domain count
     */
    private Integer domainCount;

    /**
     * String -> domain Name, List<String> -> objectName list in same domain
     */
    private Map<String, List<String>> objectNames = new HashMap<String, List<String>>();


    public ObjectNamesVO(Integer domainCount, Map<String, List<String>> objectNames) {
        this.domainCount = domainCount;
        this.objectNames = objectNames;
    }

    public ObjectNamesVO(Integer domainCount, Set<ObjectName> set) {
        this.domainCount = domainCount;
        setObjectNames(set);
    }

    private void parseObjectNameSet2Map(Set<ObjectName> set) {
        String domain, keyPropertyListString;
        for (ObjectName objectName :
                set) {
            domain = objectName.getDomain();
            keyPropertyListString = objectName.getKeyPropertyListString();
            if (objectNames.containsKey(domain)) {
                objectNames.get(domain)
                        .add(keyPropertyListString);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(keyPropertyListString);
                objectNames.put(domain, list);
            }
        }
    }

    public void setObjectNames(Set<ObjectName> set) {
        parseObjectNameSet2Map(set);
    }

    public Integer getDomainCount() {
        return domainCount;
    }

    public void setDomainCount(Integer domainCount) {
        this.domainCount = domainCount;
    }

    public Map<String, List<String>> getObjectNames() {
        return objectNames;
    }

    public void setObjectNames(Map<String, List<String>> objectNames) {
        this.objectNames = objectNames;
    }

    @Override
    public String toString() {
        return "ObjectNamesVO{" +
                "domainCount=" + domainCount +
                ", objectNames=" + objectNames +
                '}';
    }
}
