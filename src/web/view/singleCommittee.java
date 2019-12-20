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

public class singleCommittee extends HttpServlet {
    private DBUtils db;
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        db = new DBUtils();
        String committee_id;
        if (request.getParameter("committee_id") != null) {
            committee_id = request.getParameter("committee_id");
        }
        else {
            committee_id = (String) request.getAttribute("committee_id");
        }
        System.out.println(committee_id);
        Committee committee = db.retrieveCommittees("select * from committee where committee_id = "
                + committee_id).get(0);
        List<People> members = db.retrievePeople(Committee.getAllPeopleInCommitteeById(committee_id));
        String sqlQuery = "select * from people where people_id not in (select people_id from committee_people_relation " +
                "where committee_id = "+committee_id+")";
        List<People> notMembers = db.retrievePeople(sqlQuery);

        request.setAttribute("members", members);
        request.setAttribute("committee", committee);
        request.setAttribute("notMembers", notMembers);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        RequestDispatcher view = getServletContext().getRequestDispatcher("/view/singleCommitteeView.jsp");
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
