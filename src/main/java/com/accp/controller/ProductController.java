package com.accp.controller;

import com.accp.common.BaseController;
import com.accp.entity.Product;
import com.accp.server.ProductServer;
import com.accp.util.AjaxRtn;
import com.accp.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/4/10.
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {
    @Resource
    private ProductServer productServer;
    @RequestMapping("index")
    public String index()throws Exception{
        List<Product> productList=productServer.listProduct();
        request.setAttribute("productList",productList);
        return "index";

    }
    @RequestMapping("/list")
    @ResponseBody
    public Object list(Pager pager)throws Exception{
      // Page<Product> utPage = PageHelper.startPage(product.getPage(),product.getRows());
       // userService.selectList(ut);
        String sql="select * from product limit "+((pager.getPage()-1)* pager.getRows())+","+pager.getRows()+"";
        String sqlcount="select count(*) as count from product";
        List<Map> list=productServer.executeSql(sql);
       int count=productServer.countProduct(sqlcount);
        return new AjaxRtn(true,(count%pager.getRows()==0?count/pager.getRows():count/pager.getRows()+1),list);
    }
    @RequestMapping("detail")
    public String getProductById()throws Exception{
        Product product=productServer.getProductById("98a71c6cf8d54d14b4c045be90e3bb23");
        request.setAttribute("product",product);
        return "/index";

    }
}
