package com.itdr.dao;

import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {

    public List<Users> selectAll(String pagesize, String pageNum) {
       // ComboPooledDataSource co = PoolUtil.getCom();
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from users ";
        List<Users> li = null;
        try {
            li = qr.query(sql, new BeanListHandler<Users>(Users.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  li;


    }
    public Users selectOne(String username, String password) {

        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from users where username=?and psd= ?";
        Users u  = null;
        try {
            u = qr.query(sql, new BeanHandler<Users>(Users.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  u;


    }
    //根据ID查找用户
    public Users selectOne(Integer uid) {

        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from users where id=?";
        Users u  = null;
        try {
            u = qr.query(sql, new BeanHandler<Users>(Users.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  u;


    }
    public int  uodateByUid(Integer uid) {

        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from users where id=?";
        int row=0;
        try {
            row = qr.update(sql, new BeanHandler<Users>(Users.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  row;


    }
}
