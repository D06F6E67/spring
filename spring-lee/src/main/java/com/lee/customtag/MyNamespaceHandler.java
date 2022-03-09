package com.lee.customtag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 自定义命名空间
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    /**
     * 注册自定义的解析器
     */
    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
