package dao;

import model.Courier;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourierDAO {
    public Courier check_id(String id){
        Courier courier = null ;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try{
            connection = JdbcUtil.getUserConnection();
            if(connection == null){
                System.out.println("connect is null");
            }
            String sql = "select * from courier where courier_id=?";
            pstmt = (PreparedStatement)connection.prepareStatement(sql);
            pstmt.setString(1,id);
            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                courier = new Courier();
                courier.setCourier_id(resultSet.getString("courier_id"));
                courier.setName(resultSet.getString("name"));
                courier.setMobile(resultSet.getString("mobile"));
                courier.setPassword(resultSet.getString("password"));
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(resultSet);
            JdbcUtil.close(connection);
            JdbcUtil.close(pstmt);
        }

        return courier;
    }

    public void create(String courier_id,String name,String mobile,String password){
        String sql = "insert into courier values(?,?,?,?)";
        Connection connection = null;
        PreparedStatement pstmt = null;
        try{
            connection = JdbcUtil.getUserConnection();
            pstmt = (PreparedStatement)connection.prepareStatement(sql);
            pstmt.setString(1,courier_id);
            pstmt.setString(2,name);
            pstmt.setString(3,password);
            pstmt.setString(4,mobile);
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(pstmt);
            JdbcUtil.close(connection);
        }
    }

}
