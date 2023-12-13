package controller;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Courier;
import service.GetUserInfo;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getUser")
public class GetUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courier_id = request.getParameter("id");
        Courier courier = GetUserInfo.getInfo(courier_id);
        Gson gson = new Gson();
        String json = gson.toJson(courier);
        System.out.println("接收的id:"+courier_id);
        System.out.println("发送的数据："+json);
        PrintWriter out = response.getWriter();
        out.write(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
