import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test1 {
//    @Test
    public void Test1() throws SQLException {
        ComboPooledDataSource co =new ComboPooledDataSource();
        Connection connection=co.getConnection();//通过这个链接获取对象
        String sql="select * from Users";//sql语句        PreparedStatement ps=connection.prepareStatement(sql);
        PreparedStatement ps=connection.prepareStatement(sql);//传入sql语句
        ResultSet rs=ps.executeQuery();
        while (rs.next()){//遍历
            System.out.println(rs.getString(2));
        }
    }
//    @Test
    public  void  test2(){
        String s = "/list.do";
        String s1=s.replace(".","/");
        System.out.println(s1);
        String[] sar= s1.split("/");
//        for (int i = 0; i < sar.length;i++ ){
//            System.out.println(sar[i]);
//
//
//        ]
        System.out.println(sar[1]);

    }


}
