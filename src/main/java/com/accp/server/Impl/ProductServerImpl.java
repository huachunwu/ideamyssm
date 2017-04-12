package com.accp.server.Impl;

import com.accp.dao.ProductMapper;
import com.accp.entity.Product;
import com.accp.server.ProductServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/4/12.
 */
@Service
public class ProductServerImpl implements ProductServer {
    @Resource
    private ProductMapper productMapper;
    public List<Product> listProduct() throws Exception{
        List<Product> listProduct=productMapper.selectProduct();
        return listProduct;
    }
    public Product getProductById(String id) throws Exception{
        Product product=productMapper.selectByPrimaryKey(id);
        return product;
    }
    public   List<Map> executeSql(String sql) throws Exception{
        List<Map> list=new ArrayList<Map>();
        list=productMapper.executeSql(sql);
        return list;
    }
    public int countProduct(String sql) throws Exception{
        int count=productMapper.countProduct(sql);
        return count;
    }
}
