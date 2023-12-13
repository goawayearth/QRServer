package service;

import com.google.zxing.WriterException;
import dao.DeliveryDAO;
import model.Delivery;
import util.CreateQR;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetDelivery {
    public static List<String> getDeliveryURL(String uid) throws IOException, WriterException {
        List<Delivery>deliveries = DeliveryDAO.getDelivery_uid(uid);
        List<String>result = new ArrayList<>();
        for(int i=0;i<deliveries.size();i++){
            String message = deliveries.get(i).getExpress_num()+"&"+
                    deliveries.get(i).getCourier_id()+"&"+
                    deliveries.get(i).getRname()+"&"+
                    deliveries.get(i).getRaddress()+"&"+
                    deliveries.get(i).getRmobile()+"&"+
                    deliveries.get(i).getSname()+"&"+
                    deliveries.get(i).getSaddress()+"&"+
                    deliveries.get(i).getSmobile()+"&"+
                    deliveries.get(i).getType();
            CreateQR.generateQRCodeImage(message,deliveries.get(i).getExpress_num()+".png");
            //创建完二维码
            String res = deliveries.get(i).getExpress_num();
            result.add(res);
        }
        return result;

    }
}
