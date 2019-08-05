package com.itdr.service;

import com.itdr.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;

import java.util.List;

public class UserService {
    UserDao ud=new UserDao();
    public ResponseCode selectAll(String pageSize, String pageNum) {
        if (pageSize == null || pageSize.equals("")) {
            pageSize = "10";
        }
        if (pageNum == null || pageNum.equals("")) {
            pageNum = "1";
        }

        List<Users> li = ud.selectAll(pageSize, pageNum);

        ResponseCode rs = new ResponseCode();
        rs.getStats();
        rs.setData(li);
        return rs;
    }
    //用户登录


    public ResponseCode selectOne(String username, String password) {
        ResponseCode rs = new ResponseCode();

        //非空判断 时空直接返回
        if (username == null || username.equals("") || password == null || password.equals("")) {
            rs.setStats(1);
            rs.setMag("账户或密码失败");
            return rs;
        }


        //查找是否有这样一个用户
        Users u = ud.selectOne(username, password);

        //如果用户不存在
        if (u == null) {
            rs.setStats(1);
            rs.setMag("账户或密码失败");
            return rs;

        }
        //用户权限
        if (u.getType()!=1) {
            rs.setStats(2);
            rs.setMag("没有操作权限");
            return rs;

        }
        rs.setStats(0);
        rs.setData(u);
        return  rs;

    }
    //用户禁用
    public ResponseCode selectOne(String uids) {
           ResponseCode rs = new ResponseCode();

        //非空判断 时空直接返回
        if (uids == null || uids.equals("")) {
            rs.setStats(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }

        //字符串转数字
        Integer uid=null;
        try{
            uid =Integer.parseInt(uids);
        }catch (Exception e){
            rs.setStats(105);
            rs.setMag("输入非法参数");
        }


        //查找是否有这样一个用户
        Users u = ud.selectOne(uid);

        //如果用户不存在
        if (u == null) {
            rs.setStats(Const.USER_NO_CODE);
            rs.setMag(Const.USER_NO_MSG);
            return rs;

        }
        //用户禁用情况
        if (u.getStats()!=0) {
            rs.setStats(Const.USER_DISABLE_CODE);
            rs.setMag(Const.USER_DISABLE_MSG);
            return rs;

        }
       
      int row=ud.uodateByUid(uid);
        if(row<=0){
            rs.setStats(106);
            rs.setMag(" 用户禁用更新失败");
            return  rs;
        }rs.setStats(0);
        rs.setData(row);
        return  rs;

    }
    //用户查找
    public ResponseCode UserSelect(String uids){
        ResponseCode rs=new ResponseCode();
        if(uids==null||uids.equals("")){
            rs.setStats(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return  rs;
        }
        //字符串转数字
        Integer  uid = null;
        try{
            uid = Integer.parseInt(uids);
        }catch (Exception e){
            rs.setStats(105);
            rs.setMag("输入非法参数");
        }
        //查找是否有这个用户
        Users  u = ud.selectOne(uid);
        //如果用户不存在
        if(u==null){
            rs.setStats(Const.USER_NO_CODE);
            rs.setMag(Const.USER_NO_MSG);
        }
        rs.setStats(0);
        rs.setData(u);
        return rs;
    }





}

