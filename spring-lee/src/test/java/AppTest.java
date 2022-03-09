import com.lee.bean.Hello;
import com.lee.bean.TestBean;
import com.lee.bean.custom.User;
import com.lee.bean.lookup.GetBeanTest;
import com.lee.bean.replaced.TestChangeMethod;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("deprecation")
public class AppTest {

    /**
     * dtd格式的xml
     */
    @Test
    public void getBeatByXmlDtd() {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("dtd.xml"));
        TestBean testBean = (TestBean) xmlBeanFactory.getBean("testBean");
        assertEquals("test", testBean.getString());
    }

    /**
     * xsd格式的xml
     */
    @Test
    public void getBeatByXmlXsd() {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("xsd.xml"));
        TestBean testBean = (TestBean) xmlBeanFactory.getBean("testBean");
        // TestBean testBean1 = (TestBean) xmlBeanFactory.getBean("#1");
        // TestBean testBean2 = (TestBean) xmlBeanFactory.getBean("#2");
        assertEquals("test", testBean.getString());
        // assertEquals("test", testBean1.getString());
        // assertEquals("test", testBean2.getString());
    }

    /**
     * 获取文件的输入流
     */
    @Test
    public void getInputStream() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("xsd.xml");
        InputStream inputStream = classPathResource.getInputStream();
    }

    /**
     * <lookup-method>标签解析
     */
    @Test
    public void lookupMethod() {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("xsd-look-method.xml"));
        GetBeanTest getBeanTest = (GetBeanTest)xmlBeanFactory.getBean("getBeanTest");
        getBeanTest.showMe();
    }

    /**
     * <replaced-method>标签解析
     */
    @Test
    public void replacedMethod() {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("xsd-replaced-method.xml"));
        TestChangeMethod testChangeMethod = (TestChangeMethod) xmlBeanFactory.getBean("testChangeMethod");
        System.out.println(testChangeMethod.changeMe(1, "123"));
    }

    /**
     * <constructor-arg>标签的解析
     */
    @Test
    public void hello() {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("xsd-constructor-arg.xml"));
        Hello hello = (Hello) xmlBeanFactory.getBean("hello");
        hello.say();
    }

    /**
     * 自定义的标签解析
     */
    @Test
    public void custom() {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("xsd-custom.xml"));
        User testBean = (User) xmlBeanFactory.getBean("testBean");
        System.out.println(testBean.getUserName() + ", " + testBean.getEmail());
    }

    /**
     * Cause: assert shortName != key断言的错误根源
     * docs.gradle' line: 156 会校验spring.schemas文件个内容格式，当格式不正确时就会报错
     * 其中使用的校验方法中的正则测试如下
     */
    @Test
    public void test() {
        String key = "http\\://www.lee.com/schema/user/spring-user.xsd";
        String s = key.replaceAll("http.*schema.(.*).spring-.*", "$1");
        System.out.println(s);
    }

}
