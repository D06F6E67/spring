package com.lee.bean.replaced;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestMethodReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("替换");
        System.out.println(method.getName());
        System.out.println(Arrays.toString(args));
        Integer integer = Integer.valueOf(args[0].toString()) + 1;
        return integer + args[1].toString() + "a";
    }
}
