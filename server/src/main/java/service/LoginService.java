package service;

import dao.CourierDAO;
import model.Courier;

public class LoginService {

    public static String userLogin(String id, String password) {
        //调用Dao层查询方法，通过学号查询用户对象
        Courier courier = new Courier();
        CourierDAO dao = new CourierDAO();
        courier = dao.check_id(id);

        //判断用户对象是否为空
        if(courier == null){
            return "用户不存在";
        }

        //判断密码是否正确
        if(!password.equals(courier.getPassword())){
            return "用户密码不正确";
        }
        //连接成功
        return "success";
    }
}
