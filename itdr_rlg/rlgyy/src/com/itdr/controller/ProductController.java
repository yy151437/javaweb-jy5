package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Products;
import com.itdr.pojo.Users;
import com.itdr.service.ProductsService;
import com.itdr.utils.PathUtil;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/manage/product/list.do")
public class ProductController extends HttpServlet {
    private ProductsService uc = new ProductsService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        //怎么获取请求路径
        String pathInfo = request.getPathInfo();
        String path = PathUtil.getPath(pathInfo);

        ResponseCode rs = null;


        //判断是什么样的请求
        switch (path) {
            case "list":
                rs = listDo(request);
                break;
        }
        //返回响应数据

        response.getWriter().write(rs.toString());
    }
    private ResponseCode listDo(HttpServletRequest request) {
        ResponseCode rs = new ResponseCode();
            HttpSession session = request.getSession();
            Products p = (Products) session.getAttribute("Products");
            if (p == null) {
                rs.setStats(10);;
                rs.setMag("用户未登录，请登录");
                return rs;

            }
            //获取参数
            String pageSize = request.getParameter("pageSize");
            String pageNum = request.getParameter("pageNum");

            rs = uc.selectAll(pageSize, pageNum);


            //调用业务层处理业务
            return rs;
        }
    }


