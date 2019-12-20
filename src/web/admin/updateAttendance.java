package web.admin;

import Objects.eventPeopleRelation;
import database.DBUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class updateAttendance extends HttpServlet {
    private DBUtils db;
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        db = new DBUtils();
        String event_id = request.getParameter("currentEvent");
        String people_id = request.getParameter("currentPeople");
        String attendance = request.getParameter("attendance");
        int key= -1;
        try {
            key = db.modify(eventPeopleRelation.updateAttendance(Integer.parseInt(event_id), Integer.parseInt(people_id),
                    Integer.parseInt(attendance)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //if it prints out -1, it means the data modification in database did not succeed;
        System.out.println(key);

        request.setAttribute("event_id", event_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/singleEvent");
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
