package service;

import dao.DeliveryDAO;

public class DeleteDelivery {
    public static void delete(String express_num){
        DeliveryDAO.deleteDelivery(express_num);
    }
}
