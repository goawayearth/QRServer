package service;

import dao.CourierDAO;
import model.Courier;

public class RegisterService {

    public static String CreateCourier(String id, String name,String password,String phone) {
        //调用Dao层查询方法，通过学号查询用户对象
        Courier courier = new Courier();
        CourierDAO dao = new CourierDAO();
        //检查账号是否已经存在
        courier = dao.check_id(id);
        if(courier!=null){
            return "该账号已经存在！";
        }
        else{
            dao.create(id,name,phone,password);
            return "success";
        }
    }
}
