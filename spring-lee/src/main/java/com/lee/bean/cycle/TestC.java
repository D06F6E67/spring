package com.lee.bean.cycle;

public class TestC {
    private TestA testA;

    public TestC(TestA testA) {
        this.testA = testA;
    }

    public void c() {
        testA.a();
    }
    public TestA getTestA() {
        return testA;
    }

    public void setTestA(TestA testA) {
        this.testA = testA;
    }
}
