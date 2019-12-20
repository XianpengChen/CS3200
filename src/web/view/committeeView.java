package web.view;

import Objects.Committee;
import Objects.People;
import database.DBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
public class committeeView extends HttpServlet {
    private DBUtils db;
    private List<Committee> committees;
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        db = new DBUtils();
        committees = db.retrieveCommittees("select * from committee");
        List<People> chairs = new ArrayList<>();
        List<People> vice_chairs = new ArrayList<>();
        for (Committee comm : committees) {
            chairs.add(db.retrievePeople(People.peopleByID(comm.getChair())).get(0));
            vice_chairs.add(db.retrievePeople(People.peopleByID(comm.getVice_chair())).get(0));
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.setAttribute("committees", committees);
        request.setAttribute("chairs", chairs);
        request.setAttribute("vice_chairs", vice_chairs);

        RequestDispatcher view = getServletContext().getRequestDispatcher("/view/committeeView.jsp");
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
