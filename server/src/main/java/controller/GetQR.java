package controller;

import com.google.zxing.WriterException;
import dao.DeliveryDAO;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import model.Delivery;
import com.alibaba.fastjson.JSON;
import service.GetDelivery;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getQR")
public class GetQR extends HttpServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String uid = request.getParameter("courier_id");
        List<String> deliveries = null;
        try {
            deliveries = GetDelivery.getDeliveryURL(uid);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }
        System.out.println("发送成功");
        for(int i=0;i<deliveries.size();i++){
            System.out.println(deliveries.get(i));
        }
        String json = JSON.toJSONString(deliveries);
        out.write(json);
    }



}
