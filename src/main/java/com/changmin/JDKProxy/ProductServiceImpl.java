package com.changmin.JDKProxy;

public class ProductServiceImpl implements ProductService{
    public void addProduct(String productName){
        System.out.println("正在添加"+productName+"产品……");
    }
}
