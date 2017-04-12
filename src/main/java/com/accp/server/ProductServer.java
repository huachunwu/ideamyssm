package com.accp.server;

import com.accp.entity.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/4/12.
 */
public interface ProductServer {
    public List<Product> listProduct() throws Exception;
    public Product getProductById(String id) throws Exception;
    public  List<Map> executeSql(String sql) throws Exception;
    public int countProduct(String sql) throws Exception;
}
