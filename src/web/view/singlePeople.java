package web.view;

import Objects.Bloc;
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
import java.util.ArrayList;
import java.util.List;

public class singlePeople extends HttpServlet {
    private DBUtils db;
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        db = new DBUtils();
        String people_id = request.getParameter("people_id");
        System.out.println(people_id);

        People people = db.retrievePeople("select * from people where people_id = "
                + people_id).get(0);
        String sqlQuery1 = "select * from bloc where bloc_id in (select bloc_id from bloc_people_relation where " +
                "people_id = "+people_id+")";
        List<Bloc> blocs = db.retrieveBlocs(sqlQuery1);
        String sqlQuery2 = "select * from committee where committee_id in (select committee_id from " +
                "committee_people_relation where people_id = "+people_id+")";
        List<Committee> committees = db.retrieveCommittees(sqlQuery2);
        String sqlQuery3 = "select * from event where event_id in (select event_id from event_has_people where " +
                "people_id = "+people_id+") order by start_time asc";
        List<Event> events = db.retrieveEvents(sqlQuery3);

        List<People> chairs = new ArrayList<>();
        List<People> vice_chairs = new ArrayList<>();
        for (Committee comm : committees) {
            chairs.add(db.retrievePeople(People.peopleByID(comm.getChair())).get(0));
            vice_chairs.add(db.retrievePeople(People.peopleByID(comm.getVice_chair())).get(0));
        }
        request.setAttribute("blocs", blocs);
        request.setAttribute("people", people);
        request.setAttribute("committees", committees);
        request.setAttribute("events", events);
        request.setAttribute("chairs", chairs);
        request.setAttribute("vice_chairs", vice_chairs);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RequestDispatcher view = getServletContext().getRequestDispatcher("/view/singlePeopleView.jsp");
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
