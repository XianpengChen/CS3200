package web.admin;

import Objects.People;
import database.DBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddPeople extends HttpServlet {
    private DBUtils db;
    public void init() {
        db = new DBUtils();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("First name");
        String lastName = request.getParameter("Last name");
        String email = request.getParameter("Email");
        String phoneNumber = request.getParameter("Phone number");
        String password = request.getParameter("Password");
        String profile = request.getParameter("Profile");
        String special_accommodation = request.getParameter("Special accommodation");
        People p = new People(firstName, lastName, email, phoneNumber, password, profile, special_accommodation);
        int key = -1;
        try {
            key = db.modify(p.insertPeople());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //if it prints out -1, it means the data modification in database did not succeed;
        System.out.println(key);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doGet(request, response);
    }

    public void destroy() {

    }
}
