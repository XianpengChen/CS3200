package web.view;

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
import java.sql.SQLException;
import java.util.List;

public class eventView extends HttpServlet {
    private DBUtils db;
    private List<Event> events;
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        db = new DBUtils();

        events= db.retrieveEvents("select * from event");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.setAttribute("events", events);

        RequestDispatcher view = getServletContext().getRequestDispatcher("/view/eventView.jsp");
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
