package database;

import Objects.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {


    private String url;
    private String user;
    private String password;
    private Connection con = null;

    public DBUtils(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }
    public DBUtils() {
        JSONParser parser = new JSONParser();
        try {
            //read url, username, password from config.json
            URL path = this.getClass().getResource("config.json");
            File f = new File(path.getFile());
            Object obj = parser.parse(new FileReader(f));
            JSONObject jsonObject = (JSONObject) obj;
            this.url = (String) jsonObject.get("url");
            this.user = (String) jsonObject.get("username");
            this.password = (String) jsonObject.get("password");

        } catch (ParseException | IOException e) {
            e.printStackTrace();
            System.err.println("either file not found or file cannot be parsed into json");
        }
    }

    private Connection getConnection()
    {
         con = null;
            try {
                con = DriverManager.getConnection(url, user, password);
                return con;
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        return con;
    }

    private void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * this methods could be used for INSERT, DELETE, or UPDATE; or create a new table;
     * @param sqlQuery a sql query
     * @return an int, return -1 if this modification does not succeed; otherwise,it's fine
     */
    public int modify(String sqlQuery) throws SQLException {
        System.out.println("SQL STATEMENT: "+sqlQuery);
        int key;

        // get connection and initialize statement
        Connection con = getConnection();
        Statement stmt = con.createStatement();

        key = stmt.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);

        // extract auto-incremented ID
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) key = rs.getInt(1);

        // Cleanup
        rs.close();
        stmt.close();
        return key;
    }


    /**
     * @param sqlQuery a sql statement to retrieve 0, 1 or more people from database;
     * @return a list of people;
     */
    public List<People> retrievePeople(String sqlQuery) {
        List<People> peoples = new ArrayList<People>();
        Connection conn;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                peoples.add(new People(rs.getInt("people_id"), rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("email"),
                        rs.getString("phonenumber"), rs.getString("password"),
                        rs.getString("profile"), rs.getString("special_accommodation")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return peoples;
    }

    /**
     * @param sqlQuery a sql statement to retrieve 0, 1 or more committees from database;
     * @return a list of committees;
     */
    public List<Committee> retrieveCommittees(String sqlQuery) {
        List<Committee> committees = new ArrayList<Committee>();
        Connection conn;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                committees.add(new Committee(rs.getInt("committee_id"), rs.getString("name"),
                        rs.getString("agenda"), rs.getString("chair"),
                        rs.getString("vice_chair")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return committees;
    }

    /**
     * @param sqlQuery a sql statement to retrieve 0, 1 or more blocs from database;
     * @return a list of blocs;
     */
    public List<Bloc> retrieveBlocs(String sqlQuery) {
        List<Bloc> blocs = new ArrayList<Bloc>();
        Connection conn;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                blocs.add(new Bloc(rs.getInt("bloc_id"), rs.getString("name"),
                        rs.getInt("committee_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return blocs;
    }

    /**
     * @param sqlQuery a sql statement to retrieve 0, 1 or more args from database;
     * @return a list of args;
     */
    public List<Args> retrieveArgs(String sqlQuery) {
        List<Args> LoArgs = new ArrayList<Args>();
        Connection conn;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                LoArgs.add(new Args(rs.getInt("argsID"), rs.getInt("made_by"),
                        rs.getInt("at_committee"), rs.getString("arg"),
                        rs.getInt("points"), rs.getString("made_when")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return LoArgs;

    }

    /**
     * @param sqlQuery a sql statement to retrieve 0, 1 or more EventPeopleRelations from database;
     * @return a list of EventPeopleRelations;
     */
    public List<eventPeopleRelation> retrieveEventPeopleRelations(String sqlQuery) {
        List<eventPeopleRelation> LoEPR = new ArrayList<eventPeopleRelation>();
        Connection conn;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                LoEPR.add(new eventPeopleRelation(rs.getInt("event_id"), rs.getInt("people_id"),
                        rs.getInt("committee_id"), rs.getInt("attended")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return LoEPR;

    }

    /**
     * @param sqlQuery a sql statement to retrieve 0, 1 or more CommitteePeopleRelations from database;
     * @return a list of CommitteePeopleRelations;
     */
    public List<committeePeopleRelation> retrieveCommitteePeopleRelations(String sqlQuery) {
        List<committeePeopleRelation> LoCPR = new ArrayList<committeePeopleRelation>();
        Connection conn;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                LoCPR.add(new committeePeopleRelation(rs.getInt("committee_id"), rs.getInt("people_id"),
                        rs.getString("allocation")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return LoCPR;

    }

    /**
     * @param person_id a people_id in database used to located a specific people;
     * @return the list of events the specific person signed up;
     */
    public List<Event> personSchedule(int person_id) {
        String sql = "select event_id, name, place, start_time, end_time, description\n" +
                "from Event_has_People ep join event using (event_id)\n" +
                "where ep.people_id = " + person_id + "\n" +
                "order by start_time, end_time";
        return retrieveEvents(sql);
    }

    /**
     * @param committee_id a committee_id in database used to located a specific committee;
     * @return the list of events which are held by this committee;
     */
    public List<Event> committeeSchedule (int committee_id) {
        String sql = "select event_id, name, place, start_time, end_time\n" +
                "from Event_has_People ep join event using (event_id)\n" +
                "where ep.committee_id = " + committee_id + "\n" +
                "order by start_time, end_time";
        return retrieveEvents(sql);
    }

    /**
     * @param sqlQuery a sql statement to retrieve 0, 1 or more events from database;
     * @return a list of events;
     */
    public List<Event> retrieveEvents(String sqlQuery) {
        List<Event> events = new ArrayList<Event>();
        Connection conn;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                events.add(new Event(rs.getInt("event_id"), rs.getString("name"),
                        rs.getString("place"), rs.getString("start_time"),
                        rs.getString("end_time"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return events;
    }


    public List<Args> getArgPerBloc(int bloc_id) {
        String getEventPeopleRelation = "select args_id, made_by, at_committee, arg, points, made_when " +
                "from args a join committee c on (a.at_committee = c.committee_id) " +
                "join people p on (a.made_by = p.people_id) " +
                "join bloc_people_relation using (people_id) " +
                "where bloc_id = " + bloc_id;
        List<Args> ArgPerBloc = new ArrayList<Args>();
        Connection conn;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(getEventPeopleRelation);
            while (rs.next()) {
                ArgPerBloc.add(new Args(rs.getInt("argsID"), rs.getInt("made_by"),
                        rs.getInt("at_committee"), rs.getString("arg"),
                        rs.getInt("points"), rs.getString("made_when")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return ArgPerBloc;
    }

}
