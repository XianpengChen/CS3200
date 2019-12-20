package web.view;

import Objects.Bloc;
import Objects.People;
import Objects.blocPeopleRelation;
import database.DBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class singleBloc extends HttpServlet {
    private DBUtils db;
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        db = new DBUtils();
        String bloc_id;
        if (request.getParameter("bloc_id") != null) {
            bloc_id = request.getParameter("bloc_id");
        }
        else {
            bloc_id = (String) request.getAttribute("bloc_id");
        }
        Bloc bloc = db.retrieveBlocs("select * from bloc where bloc_id = "
                + bloc_id).get(0);
        List<People> members = db.retrievePeople(blocPeopleRelation.getAllPeopleInBloc(bloc_id));
        String sqlQuery = "select * from people " +
                "where people_id in (select people_id from committee_people_relation where committee_id in " +
                "(select committee_id from bloc where bloc_id = "+bloc_id+"))" +
                "and people_id not in (select people_id from bloc_people_relation where bloc_id = "+bloc_id+")";
        List<People> notMembers = db.retrievePeople(sqlQuery);
        request.setAttribute("members", members);
        request.setAttribute("notMembers", notMembers);
        request.setAttribute("bloc", bloc);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RequestDispatcher view = getServletContext().getRequestDispatcher("/view/singleBlocView.jsp");
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
