package Objects;

/**
 * Arguments are a central component to the MUN Conference as they
 * are what the scoring system is based off of
 */

public class Args {

    private int argsID;
    private int made_by;
    private int at_committee;
    private String arg;
    private int points;
    private String made_when;

    public Args(int argsID, int made_by, int at_committee, String arg, int points, String made_when) {
        this.argsID = argsID;
        this.made_by = made_by;
        this.at_committee = at_committee;
        this.arg = arg;
        this.points = points;
        this.made_when = made_when;
    }

    /**
     * @return a sql statement which would be used to insert this arg into database;
     */
    public String insertArgs() {
        return "insert into args (made_by, at_committee, arg, points, made_when) values ("+made_by+", "+at_committee+", " +
                "\'"+arg+"\', "+points+", \'"+made_when+"\')";
    }

    /**
     * @return a sql statement which would be used to delete this arg from database;
     */
    public String deleteArgs() {
        return "delete from args where arg = \'"+arg+"\'";
    }

    /**
     * notice: both column names are one of: "args_id", "made_by", "at_committee", "arg", "points", "made_when";
     * @param updateColumnName the name of column which would be updated;
     * @param updateColumnValue the value used to update the column;
     * @param selectColumnName the name of column used to specify a row;
     * @param selectColumnValue the value of the column above used to specify a row;
     * @return a sql statement used to update this arg in database;
     */
    public String updateArgs(String updateColumnName, String updateColumnValue, String selectColumnName,
                             String selectColumnValue) {
        return "update args set "+updateColumnName+" = \'"+updateColumnValue+"\' where "+selectColumnName+" = \'"
                +selectColumnValue+"\'";
    }

    public int getArgsID() {
        return argsID;
    }

    public void setArgsID(int argsID) {
        this.argsID = argsID;
    }

    public int getMade_by() {
        return made_by;
    }

    public void setMade_by(int made_by) {
        this.made_by = made_by;
    }

    public int getAt_committee() {
        return at_committee;
    }

    public void setAt_committee(int at_committee) {
        this.at_committee = at_committee;
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getMade_when() {
        return made_when;
    }

    public void setMade_when(String made_when) {
        this.made_when = made_when;
    }
    
}
