package com.lee.myEventListener;

import org.springframework.beans.factory.parsing.*;

public class MyReaderEventListener implements ReaderEventListener {
    @Override
    public void defaultsRegistered(DefaultsDefinition defaultsDefinition) {
        System.out.println(">>>>>>>>>>>>>>>>>默认注册");
    }

    @Override
    public void componentRegistered(ComponentDefinition componentDefinition) {
        System.out.println(">>>>>>>>>>>>>>>>>组件注册");
    }

    @Override
    public void aliasRegistered(AliasDefinition aliasDefinition) {
        System.out.println(">>>>>>>>>>>>>>>>>alias");
    }

    @Override
    public void importProcessed(ImportDefinition importDefinition) {
        System.out.println(">>>>>>>>>>>>>>>>>import");
    }
}
