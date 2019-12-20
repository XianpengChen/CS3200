package web.admin;

import Objects.Event;
import database.DBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddEvent extends HttpServlet {
    private DBUtils db;

    public void init() {
        db = new DBUtils();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("Event name");
        String place = request.getParameter("Place");
        String start_time = request.getParameter("Start time");
        String end_time = request.getParameter("End time");
        String description = request.getParameter("Description");
        String startTime = formatToDateTime(start_time);
        String endTime = formatToDateTime(end_time);
        Event event = new Event(name, place, startTime, endTime, description);
        int key = -1;
        try {
            key = db.modify(event.insertEvent());
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

    /**
     * @param datetime_local a string in the form of: "2019-04-16T13:00"
     * @return a string in the form of: "2019-04-16 13:00:00"
     */
    private String formatToDateTime(String datetime_local) {
        String[] str = datetime_local.split("T");
        return str[0] + " " + str[1] + ":00";
    }
}
