package com.demo.webshopautomation.business;

import com.demo.webshopautomation.repository.IUrlHelper;
import com.demo.webshopautomation.utils.UrlSelector;

import java.util.HashMap;
import java.util.Map;

public class UrlHelper implements IUrlHelper {

    private final Map<UrlSelector, String> urlCollection;

    public UrlHelper(){
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