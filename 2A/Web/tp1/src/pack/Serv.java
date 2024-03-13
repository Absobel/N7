package pack;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Serv extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("calculator.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int sum = num1 + num2;

        req.setAttribute("sum", sum);
        req.getRequestDispatcher("/calculator.jsp").forward(req, resp);        
    }
}