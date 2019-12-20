package Objects;

/**
 * represents the people is a member of this committee;
 */
public class committeePeopleRelation {
    private int committee_id;
    private int people_id;
    private String allocation;
    public committeePeopleRelation(int committee_id, int people_id, String allocation) {
        this.committee_id = committee_id;
        this.people_id = people_id;
        this.allocation = allocation;
    }

    /**
     * @return a sql statement which would be used to add a people to a committee in database;
     */
    public String insertCommitteePeopleRelation() {
        return "insert into committee_people_relation values ("+committee_id+", "+people_id+", \'"+allocation+"\')";
    }

    /**
     * @return a sql statement which would be used to remove a people from a committee in database;
     */
    public String deleteCommitteePeopleRelation() {
        return "delete from committee_people_relation where committee_id = "+committee_id+" and people_id = "+people_id;
    }

    /**
     * @return a sql statement used to update one people's allocation in one committee;
     */
    public String updateCommitteePeopleRelation(String alloc) {
        return "update committee_people_relation set allocation = \'"+alloc+"\' where committee_id = "+committee_id+
                " and people_id = " + people_id;
    }

    public int getCommittee_id() {
        return committee_id;
    }

    public int getPeople_id() {
        return people_id;
    }

    public String getAllocation() {
        return allocation;
    }

    public void setCommittee_id(int committee_id) {
        this.committee_id = committee_id;
    }

    public void setPeople_id(int people_id) {
        this.people_id = people_id;
    }

    public void setAllocation(String allocation) {
        this.allocation = allocation;
    }
}
