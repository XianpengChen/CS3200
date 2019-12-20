package web.view;

import Objects.Committee;
import Objects.Event;
import Objects.People;
import database.DBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class singleEvent extends HttpServlet {
    private DBUtils db;
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        db = new DBUtils();
        String event_id;
        if (request.getParameter("event_id") != null) {
            event_id = request.getParameter("event_id");
        }
        else {
            event_id = (String) request.getAttribute("event_id");
        }
        Event event = db.retrieveEvents("select * from event where event_id = "
                + event_id).get(0);
        List<People> registered = db.retrievePeople(Event.getAllPeopleByEventID(event_id));
        String sqlQuery = "select * from people where people_id not in (select people_id from Event_has_People where " +
                "event_id = "+event_id+")";
        List<People> notRegistered = db.retrievePeople(sqlQuery);

        request.setAttribute("registered", registered);
        request.setAttribute("event", event);
        request.setAttribute("notRegistered", notRegistered);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RequestDispatcher view = getServletContext().getRequestDispatcher("/view/singleEventView.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        out.write("");
        out.close();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doGet(request, response);
    }

    public void destroy() {

    }
}
