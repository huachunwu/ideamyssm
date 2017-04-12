package com.accp.dao;

import com.accp.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Product record);
    List<Product> selectProduct();
    int updateByPrimaryKey(Product record);
    List<Map> executeSql(String sql);
    public int countProduct(String sql);
}