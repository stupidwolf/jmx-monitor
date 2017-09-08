package com.ztesoft.jmx.monitor.mbean.view.service.impl;

import com.ztesoft.jmx.monitor.connection.exception.ConnInvalidException;
import com.ztesoft.jmx.monitor.mbean.view.dto.MBeanDTO;
import com.ztesoft.jmx.monitor.mbean.view.exception.MBeanException;
import com.ztesoft.jmx.monitor.mbean.view.exception.MBeanInfoNotFoundException;
import com.ztesoft.jmx.monitor.mbean.view.model.MBeanAttr;
import com.ztesoft.jmx.monitor.mbean.view.model.MBeanOperation;
import com.ztesoft.jmx.monitor.mbean.view.model.OperationArg;
import com.ztesoft.jmx.monitor.mbean.view.service.IMBeanViewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.management.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Service
public class MBeanViewServiceImpl implements IMBeanViewService {
    private Logger logger = LoggerFactory.getLogger(MBeanViewServiceImpl.class);

    @Override
    public MBeanDTO getMBeanDTO(MBeanServerConnection mBeanServerConnection, String domain, String objectNameString)
            throws MBeanException, MBeanInfoNotFoundException,
            ConnInvalidException {
        if (mBeanServerConnection == null) {
            throw new ConnInvalidException();
        }
        MBeanDTO mBeanDTO;

        ObjectName objectName;
        MBeanInfo mBeanInfo;

        //获取 objectName
        objectName = getObjectName(mBeanServerConnection, domain, objectNameString);

        //获取 mBeanInfo
        mBeanInfo = getMBeanInfo(mBeanServerConnection, objectName);

        //mBeanInfo -> mBeanDTO
        mBeanDTO = transferMBeanInfo2MBeanDTO(mBeanInfo);
        //FIXME 获取并设置mBean name
        mBeanDTO.setMbeanName(objectName.getDomain() + ":" + objectName.getKeyPropertyListString());
        return mBeanDTO;
    }

    private MBeanDTO transferMBeanInfo2MBeanDTO(MBeanInfo mBeanInfo) {
        MBeanDTO mBeanDTO;
//        String name;
        String description;
        String className;
        MBeanAttributeInfo[] attributeInfos;
        MBeanOperationInfo[] operationInfos;


        //获取mBeanInfo 相关属性
//        name = mBeanInfo.
        description = mBeanInfo.getDescription();
        className = mBeanInfo.getClassName();
        attributeInfos = mBeanInfo.getAttributes();
        operationInfos= mBeanInfo.getOperations();

        mBeanDTO = new MBeanDTO();
        mBeanDTO.setMbeanDescription(description);
        mBeanDTO.setMbeanClass(className);
        mBeanDTO.setmBeanAttrList(transferMBeanInfoAttrs2List(attributeInfos));
        mBeanDTO.setmBeanOperationList(transferMBeanOperation2List(operationInfos));
        return mBeanDTO;
    }

    private List<MBeanAttr> transferMBeanInfoAttrs2List(MBeanAttributeInfo[] attributeInfos) {
        List<MBeanAttr> mBeanAttrList = new LinkedList<MBeanAttr>();
        MBeanAttr mBeanAttr;
        if (attributeInfos != null) {
            for (MBeanAttributeInfo attribute :
                    attributeInfos) {
                mBeanAttr = new MBeanAttr();
                mBeanAttr.setDescription(attribute.getDescription());
                mBeanAttr.setName(attribute.getName());
                mBeanAttr.setType(attribute.getType());
                mBeanAttr.setReadable(attribute.isReadable());
                mBeanAttr.setWritable(attribute.isWritable());
                mBeanAttr.setValue(mBeanAttr.getValue());
                mBeanAttrList.add(mBeanAttr);
            }
        }
        return mBeanAttrList;
    }

    private List<MBeanOperation> transferMBeanOperation2List(MBeanOperationInfo[] operationInfos) {
        List<MBeanOperation> mBeanOperationList = new LinkedList<MBeanOperation>();
        MBeanOperation mBeanOperation;
        if (operationInfos != null) {
            for (MBeanOperationInfo operationInfo :
                    operationInfos) {
                mBeanOperation = new MBeanOperation();
                mBeanOperation.setDescription(operationInfo.getDescription());

                mBeanOperation.setReturnType(operationInfo.getReturnType());
                mBeanOperation.setOperationName(operationInfo.getName());

                //设置方法参数
                mBeanOperation.setArgs(
                        transferMBeanParameter2List(
                                operationInfo.getSignature()));


                mBeanOperationList.add(mBeanOperation);
            }
        }
        return mBeanOperationList;
    }

    private List<OperationArg> transferMBeanParameter2List(MBeanParameterInfo[] parameterInfos) {
        List<OperationArg> operationArgList = new LinkedList<OperationArg>();
        OperationArg operationArg;
        if (parameterInfos != null) {
            for (MBeanParameterInfo parameterInfo :
                    parameterInfos) {
                operationArg = new OperationArg();
                operationArg.setName(parameterInfo.getName());
                operationArg.setType(parameterInfo.getType());

                operationArgList.add(operationArg);
            }
        }
        return operationArgList;
    }


    private ObjectName getObjectName(MBeanServerConnection mBeanServerConnection, String domain, String objectNameString) throws MBeanInfoNotFoundException{
        ObjectName objectName;
        try {
            //get objectName info
            //"jmxBean:name=hello"
            objectName = new ObjectName(domain + ":" + objectNameString);
        } catch (MalformedObjectNameException e) {
            logger.error("detail msg: {}", e.getMessage(), e);
            throw new MBeanInfoNotFoundException();
        }
        return objectName;
    }

    private MBeanInfo getMBeanInfo(MBeanServerConnection mBeanServerConnection, ObjectName objectName) throws MBeanException, MBeanInfoNotFoundException,
            ConnInvalidException {
        MBeanInfo mBeanInfo;
        try {
            mBeanInfo = mBeanServerConnection.getMBeanInfo(objectName);
        } catch (InstanceNotFoundException e) {
            logger.error("not found, detail msg: {}", e);
            throw new MBeanInfoNotFoundException();
        } catch (IntrospectionException e) {
            logger.error("IntrospectionException: {}", e);
            throw new MBeanException("IntrospectionException", e);
        } catch (ReflectionException e) {
            logger.error("ReflectionException: {}", e);
            throw new MBeanException("ReflectionException", e);
        } catch (IOException e) {
            logger.error("IOException: {}", e);
            throw new ConnInvalidException();
        }
        return mBeanInfo;
    }
}
