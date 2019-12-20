package Objects;

/**
 * Represents an event that occurs during the conference, can include a committee session
 */
public class Event {

  private int eventID;
  private String name;
  private String place;
  private String start_time;
  private String end_time;
  private String description;

  public Event(int eventID, String name, String place, String start_time, String end_time, String description) {
    this.eventID = eventID;
    this.name = name;
    this.place = place;
    this.start_time = start_time;
    this.end_time = end_time;
    this.description = description;
  }
  public Event(String name, String place, String start_time, String end_time, String description) {
    //-1 does not mean the actual id, it's just a place holder;
    this.eventID = -1;
    this.name = name;
    this.place = place;
    this.start_time = start_time;
    this.end_time = end_time;
    this.description = description;
  }

  /**
   * @return a sql statement which would be used to insert this event into database;
   */
  public String insertEvent() {
    return "insert into event (name, place, start_time, end_time, description) values (\'"+name+"\', \'"+place+"\', " +
            "\'"+start_time+"\', \'"+end_time+"\', \'"+description+"\')";
  }

  /**
   * @return a sql statement which would be used to delete this event from database;
   */
  public String deleteEvent() {
    return "delete from event where name = \'"+name+"\'";
  }

  /**
   * notice: both column names are one of: "event_id", "name", "place", "start_time", "end_time", "description";
   * @param updateColumnName the name of column which would be updated;
   * @param updateColumnValue the value used to update the column;
   * @param selectColumnName the name of column used to specify a row;
   * @param selectColumnValue the value of the column above used to specify a row;
   * @return a sql statement used to update this event in database;
   */
  public String updateEvent(String updateColumnName, String updateColumnValue, String selectColumnName, String selectColumnValue) {
    return "update event set "+updateColumnName+" = \'"+updateColumnValue+"\' where "+selectColumnName+" = \'"
            +selectColumnValue+"\'";
  }

  public static String getAllPeopleByEventID(String eventId) {
    return "select * from people where people_id in (select people_id from Event_has_People where " +
            "event_id = "+eventId+")";
  }

  public int getEventID() {
    return eventID;
  }

  public void setEventID(int eventID) {
    this.eventID = eventID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public String getStart_time() {
    return start_time;
  }

  public void setStart_time(String start_time) {
    this.start_time = start_time;
  }

  public String getEnd_time() {
    return end_time;
  }

  public void setEnd_time(String end_time) {
    this.end_time = end_time;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
