package com.lee;

import com.lee.myEventListener.MyReaderEventListener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lee extends ClassPathXmlApplicationContext {

    public Lee(String... configLocation) throws BeansException {
        super(configLocation);
    }

    @Override
    protected void initBeanDefinitionReader(XmlBeanDefinitionReader reader) {
        super.initBeanDefinitionReader(reader);
        reader.setEventListener(new MyReaderEventListener());
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Lee lee = new Lee("xsd.xml");
        Object testBean = lee.getBean("testBean");
    }
}
