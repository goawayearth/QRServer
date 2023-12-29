package service;

import dao.CourierDAO;
import dao.DeliveryDAO;
import model.Courier;

public class GetUserInfo {


    public static Courier getInfo(String id){
        Courier courier = new CourierDAO().check_id(id);
        courier.setNum(DeliveryDAO.getDelivery_uid(id).size());
        return courier;
    }
}
