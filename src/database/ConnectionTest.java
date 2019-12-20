package database;

import Objects.People;

import java.util.List;

//this was used to test JDBC connection
public class ConnectionTest {
    public static void main(String[] args) {
        DBUtils utils = new DBUtils();
        //to print out people data in console
        List<People> peoples;

        peoples = utils.retrievePeople("select * from people");

        for (People p : peoples) {
            p.printPeople();
        }
    }
}
