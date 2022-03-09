package com.lee.bean.lookup;

public abstract class GetBeanTest {
    public void showMe() {
        this.getBean().showMe();
    }
    public abstract User getBean();
}
