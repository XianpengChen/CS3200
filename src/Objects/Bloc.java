package Objects;

/**
 * Represents a set of shared arguments for a committee, delegates form blocs within a committee
 * based on what their stance on an issue is.
 */

public class Bloc {

    private int bloc_id;
    private String name;
    private int committeeID;

    public Bloc(int bloc_id, String name, int committeeID) {
        this.bloc_id = bloc_id;
        this.name = name;
        this.committeeID = committeeID;
    }

    /**
     * @return a sql statement which would be used to insert this bloc into database;
     */
    public String insertBloc() {
        return "insert into bloc (name, committee_id) values (\'"+name+"\', "+committeeID+")";
    }

    /**
     * @return a sql statement which would be used to delete this bloc from database;
     */
    public String deleteBLoc() {
        return "delete from bloc where name = \'"+name+"\'";
    }

    /**
     * notice: both column names are one of : "bloc_id", "name", "committee_id"
     * @param updateColumnName the name of column which would be updated;
     * @param updateColumnValue the value used to update the column;
     * @param selectColumnName the name of column used to specify a row;
     * @param selectColumnValue the value of the column above used to specify a row;
     * @return a sql statement used to update this bloc in database;
     *
     */
    public String updateBloc(String updateColumnName, String updateColumnValue, String selectColumnName,
                             String selectColumnValue) {
        return "update bloc set "+updateColumnName+" = \'"+updateColumnValue+"\' where "+selectColumnName+" = \'"
                +selectColumnValue+"\'";
    }


    public int getBloc_id() {
        return bloc_id;
    }

    public void setBloc_id(int blocId) {
        this.bloc_id = blocId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCommitteeID() {
        return committeeID;
    }

    public void setCommitteeID(int committeeID) {
        this.committeeID = committeeID;
    }
}
