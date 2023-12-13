package controller;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Courier;
import service.DeleteDelivery;
import service.GetUserInfo;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteQR")
public class DeleteQR extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String express_num = request.getParameter("express_num");
        System.out.println("收到"+express_num);
        DeleteDelivery.delete(express_num);
        PrintWriter out = response.getWriter();
        out.write("s");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
