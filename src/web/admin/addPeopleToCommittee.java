package web.admin;

import Objects.Committee;
import Objects.People;
import Objects.committeePeopleRelation;
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

public class addPeopleToCommittee extends HttpServlet {
    private DBUtils db;
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        db = new DBUtils();
        String committee_id = request.getParameter("currentCommittee");
        System.out.println(committee_id);
        String people_id = request.getParameter("newMember");
        String allocation = request.getParameter("allocation");
        committeePeopleRelation CPR = new committeePeopleRelation(Integer.parseInt(committee_id),
                Integer.parseInt(people_id), allocation);
        int key= -1;
        try {
            key = db.modify(CPR.insertCommitteePeopleRelation());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //if it prints out -1, it means the data modification in database did not succeed;
        System.out.println(key);

        request.setAttribute("committee_id", committee_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/singleCommittee");
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
