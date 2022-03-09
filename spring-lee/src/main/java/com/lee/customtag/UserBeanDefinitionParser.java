package com.lee.customtag;

import com.lee.bean.custom.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * 自定义的解析器
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    // Element对应的类
    protected Class<User> getBeanClass(Element element) {
        return User.class;
    }

    // 从element中解析并提取对应的元素
    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        String userName = element.getAttribute("userName");
        String email = element.getAttribute("email");
        // 将提取的数据放入到BeanDefinitionBuilder中，待到完成所有bean的解析后
        // 统一注册到beanFactory中
        if (StringUtils.hasText(userName))
            bean.addPropertyValue("userName", userName);
        if (StringUtils.hasText(email))
            bean.addPropertyValue("email", email);
    }
}
