package dao;

import com.google.zxing.client.j2se.StringsResourceTranslator;
import model.Courier;
import model.Delivery;
import util.JdbcUtil;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO {

    public static List<Delivery> getDelivery_uid(String uid){
        List<Delivery> deliveries = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            //连接数据库
            connection = JdbcUtil.getUserConnection();
            if(connection == null){
                System.out.println("connecting is null");
            }
            String sql = "select * from delivery where courier_id=?";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,uid);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Delivery delivery = new Delivery();
                delivery.setCourier_id(resultSet.getString("courier_id"));
                delivery.setRaddress(resultSet.getString("raddress"));
                delivery.setRmobile(resultSet.getString("rmobile"));
                delivery.setRname(resultSet.getString("rname"));
                delivery.setSaddress(resultSet.getString("saddress"));
                delivery.setSmobile(resultSet.getString("smobile"));
                delivery.setExpress_num(resultSet.getString("express_num"));
                delivery.setType(resultSet.getString("type"));
                delivery.setSname(resultSet.getString("sname"));
                deliveries.add(delivery);
            }

        }catch (Exception e){

        }finally {
            JdbcUtil.close(resultSet);
            JdbcUtil.close(connection);
            JdbcUtil.close(preparedStatement);
        }
        return deliveries;
    }

    public static void deleteDelivery(String express_num){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "delete from delivery where express_num=?";
        try{
            connection = JdbcUtil.getUserConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,express_num);
            preparedStatement.executeUpdate();
            //删除png文件
            File file = new File("D:\\STUDY\\1Android\\QRA\\QR\\server\\src\\main\\webapp\\"+express_num+".png");
            if(file.delete()){
                System.out.println("文件删除成功");
            }
        }catch (Exception e){

        }finally {
            JdbcUtil.close(connection);
            JdbcUtil.close(preparedStatement);
        }

    }




}
