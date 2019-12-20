package web.admin;

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
import java.util.List;
public class admin extends HttpServlet {
    private DBUtils db;
    private List<People> ps;
    private List<Committee> comms;
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        db = new DBUtils();
        ps= db.retrievePeople("select * from people");
        comms = db.retrieveCommittees("select * from committee");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.setAttribute("people", ps);
        request.setAttribute("committees", comms);

        RequestDispatcher view = getServletContext().getRequestDispatcher("/admin/admin.jsp");
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
