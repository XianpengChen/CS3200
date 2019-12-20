package web.admin;

import Objects.Bloc;
import Objects.Committee;
import database.DBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class addBloc extends HttpServlet {
    private DBUtils db;
    public void init() {
        db = new DBUtils();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("Bloc name");
        String committee_id = request.getParameter("toCommittee");
        Bloc bl = new Bloc(0, name, Integer.parseInt(committee_id));
        int key = -1;
        try {
            key=db.modify(bl.insertBloc());
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
