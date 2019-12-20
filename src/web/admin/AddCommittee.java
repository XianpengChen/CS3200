package web.admin;

import Objects.Committee;
import database.DBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddCommittee extends HttpServlet {
    private DBUtils db;
    public void init() {
        db = new DBUtils();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("Committee name");
        String agenda = request.getParameter("Agenda");
        String chair = request.getParameter("Chair");
        String vice_chair = request.getParameter("Vice chair");
        Committee comm = new Committee(name, agenda, chair, vice_chair);
        int key = -1;
        try {
            key = db.modify(comm.insertCommittee());
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
