package Objects;


/**
 * Committees in Model UN such as United Nations Human Rights Council (UNHRC)
 * Disarmament and International Security (DISEC) are hosted by a chair and vice chair who
 * decide the points for a Bloc's best arguments
 *
 */
public class Committee {

    private int committee_id;
    private String name;
    private String agenda;
    private String chair;
    private String vice_chair;

    public Committee(int committee_id, String name, String agenda, String chair, String vice_chair) {
        this.committee_id = committee_id;
        this.name = name;
        this.agenda = agenda;
        this.chair = chair;
        this.vice_chair = vice_chair;
    }
    public Committee(String name, String agenda, String chair, String vice_chair) {
        //-1 does not mean the actual id, it's just a place holder;
        this.committee_id = -1;
        this.name = name;
        this.agenda = agenda;
        this.chair = chair;
        this.vice_chair = vice_chair;
    }

    /**
     * @return a sql statement which would be used to insert this committee into database;
     */
    public String insertCommittee() {
        return "insert into committee (name, agenda, chair, vice_chair) values (\'"+name+"\', \'"+agenda+"\'," +
                " "+chair+", "+vice_chair+")";
    }

    /**
     * @return a sql statement which would be used to delete this committee from database using name;
     */
    public String deleteCommittee() {
        return "delete from committee where name = \'"+name+"\';";
    }

    /**
     * both column names are one of: "committee_id", "name", "agenda", "chair", "vice_chair";
     * @param updateColumnName the name of column which would be updated;
     * @param updateColumnValue the value used to update the column;
     * @param selectColumnName the name of column used to specify a row;
     * @param selectColumnValue the value of the column above used to specify a row;
     * @return a sql statement used to update this committee in database;
     */
    public String updateCommittee(String updateColumnName, String updateColumnValue, String selectColumnName,
                                  String selectColumnValue) {
        return "update committee set "+updateColumnName+" = \'"+updateColumnValue+"\' where "+selectColumnName
                +" = \'"+selectColumnValue+"\'";
    }

    /**
     * @param committee_id an int representating the id of a committee;
     * @return a sql statement to get all people in the committee having such an ID;
     */
    public static String getAllPeopleInCommitteeById(String committee_id) {
        return "select * from people where people_id in (select people_id from committee_people_relation where " +
                "committee_id = "+committee_id+")";
    }

    public int getCommittee_id() {
        return committee_id;
    }

    public void setCommittee_id(int committee_id) {
        this.committee_id = committee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getChair() {
        return chair;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    public String getVice_chair() {
        return vice_chair;
    }

    public void setVice_chair(String vice_chair) {
        this.vice_chair = vice_chair;
    }
}
