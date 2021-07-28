import models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/product","/toan"})
public class ProductServlet extends HttpServlet{
    ArrayList<Product> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        list.add(new Product(1,"Tivi",15));
        list.add(new Product(2,"Xe dap",15));
        list.add(new Product(3,"oto",15));

        // thêm cặp key - value vào request để gửi.
        req.setAttribute("listSP", list);

        // RequestDispatcher điều hướng request và response sang 1 servlet or jsp khác.
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("ShowProduct.jsp");

        // chuyển tếp request và reponse đi cho thằng servlet khác sử lý.
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        list.add(new Product(id,name,price));

        req.setAttribute("listSP", list);
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("ShowProduct.jsp");
        dispatcher.forward(req, resp);


    }
}
