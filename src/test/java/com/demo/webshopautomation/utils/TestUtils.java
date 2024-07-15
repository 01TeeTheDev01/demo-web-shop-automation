package com.demo.webshopautomation.utils;

import java.util.HashMap;
import java.util.Map;

public class TestUtils {

    private final Map<UrlSelector, String> urlCollection;

    public TestUtils(){
        urlCollection = new HashMap<>();
        initItems();
    }

    private void initItems(){
        urlCollection.put(UrlSelector.BASE, "https://demowebshop.tricentis.com/");
        urlCollection.put(UrlSelector.LOGIN, "https://demowebshop.tricentis.com/login");
    }

    public String getUrl(UrlSelector url){
        return urlCollection.get(url);
    }
}