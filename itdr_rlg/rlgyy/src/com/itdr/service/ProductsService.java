package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductsDao;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Products;
import com.itdr.pojo.Users;

import java.util.List;

public class ProductsService {


    private ProductsDao pd = new ProductsDao();


    public ResponseCode selectAll(String pageSize, String pageNum) {
         //仅仅只是查询全部的商品的信息

        if (pageSize == null || pageSize.equals("")) {
            pageSize = "10";
        }
        if (pageNum == null || pageNum.equals("")) {
            pageNum = "1";
        }
        //如果商品的信息为空呢？
        List<Products> li = pd.selectAll(pageSize, pageNum);
        ResponseCode rs = new ResponseCode();

        rs.setStats(0);
        rs.setData(li);
        return rs;
    }

}