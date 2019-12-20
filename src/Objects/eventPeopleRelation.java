package Objects;

/**
 * The most basic data type representing a member of the MUN conference
 */
public class eventPeopleRelation {
    private int event_id;
    private int people_id;
    private int committee_id;
    private int attended;//0 means unattended; 1 means attended.

    public eventPeopleRelation(int event_id, int people_id, int committee_id, int attended) {
        this.event_id = event_id;
        this.people_id = people_id;
        this.committee_id = committee_id;
        this.attended = attended;
    }

    /**
     * @return a ql statement which would be used to add a people to an event in database;
     */
    public String insertEventPeopleRelation() {
        return "insert into event_has_people values ("+event_id+", "+people_id+", "+committee_id+", "+attended+")";
    }

    /**
     * @return a ql statement which would be used to add a people to an event without a committee_id in database;
     */
    public String insertEventPeopleRelationWithOutCommittee() {
        return "insert into event_has_people (event_id, people_id, attended) values ("+event_id+", "+people_id+", 0)";
    }

    /**
     * @return a sql statement which would be used to remove a people from an event in database;
     */
    public String deleteEventPeopleRelation() {
        return "delete from event_has_people where event_id = "+event_id+" and people_id = "+ people_id;
    }

    /**
     * @param eventId used to specify an event;
     * @param peopleId used to specify a people;
     * @param attendance used to update the attendance;
     * @return a sql statement to update a people's attendance on a specific event;
     */
    public static String updateAttendance(int eventId, int peopleId, int attendance) {
        return "update event_has_people set attended = "+attendance+" where event_id = "+eventId+" and people_id = "+ peopleId;
    }

    public int getEvent_id() {
        return event_id;
    }

    public int getPeople_id() {
        return people_id;
    }

    public int getCommittee_id() {
        return committee_id;
    }

    public int isAttended() {
        return attended;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public void setPeople_id(int people_id) {
        this.people_id = people_id;
    }

    public void setCommittee_id(int committee_id) {
        this.committee_id = committee_id;
    }

    public void setAttended(int attended) {
        this.attended = attended;
    }

}
