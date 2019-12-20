package web.admin;

import Objects.blocPeopleRelation;
import database.DBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class removePeopleFromBloc extends HttpServlet {
    private DBUtils db;
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        db = new DBUtils();
        String bloc_id = request.getParameter("currentBloc");
        String people_id = request.getParameter("currentMember");
        blocPeopleRelation BPR = new blocPeopleRelation(Integer.parseInt(bloc_id), Integer.parseInt(people_id));
        int key= -1;
        try {
            key = db.modify(BPR.delete());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //if it prints out -1, it means the data modification in database did not succeed;
        System.out.println(key);

        request.setAttribute("bloc_id", bloc_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/singleBloc");
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
