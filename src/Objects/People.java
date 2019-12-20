package Objects;

/**
 * The most basic data type representing a member of the MUN conference
 */
public class People {

    private int peopleID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String profile;
    private String special_accommodation;


    public People(int peopleID, String firstName, String lastName, String email,
                  String phoneNumber, String password, String profile, String special_accommodation) {

        this.peopleID = peopleID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.profile = profile;
        this.special_accommodation = special_accommodation;
    }
    public People(String firstName, String lastName, String email,
                  String phoneNumber, String password, String profile, String special_accommodation) {
        //-1 does not mean the actual id, it's just a place holder;
        this.peopleID = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.profile = profile;
        this.special_accommodation = special_accommodation;
    }

    /**
     * @return return a sql statement which would be used to insert this people into the database;
     */
    public String insertPeople() {
        return "insert into people (firstname, lastname, email, phonenumber, password, profile, special_accommodation) " +
                "values "+ "(\'" + firstName +"\', \'"+ lastName +"\', \'"+ email+"\', \'"+ phoneNumber+"\', \'"+password+
                "\', \'"+profile+"\', \'"+ special_accommodation+"\')";
    }

    /**
     * @param columnName one of : "firstname", "lastname", "email", "phonenumber", "password", "profile", "special_accommodation",
     *                   "people_id";
     *                   recommend to use "people_id" or "email";
     * @param columnValue value in the given column;
     * @return a SQL statement to delete this people;
     */
    public String deletePeople(String columnName, String columnValue) {
        return "delete from people where "+columnName+" = \'"+columnValue+"\'";
    }

    /**
     * both column names are one of: "firstname", "lastname", "email", "phonenumber", "password", "profile",
     * "special_accommodation", "people_id";
     * @param updateColumnName the name of the column which would be updated;
     * @param updateColumnValue the value of the column which would be used to update;
     * @param selectColumnName the name of the column which is used to locate a specific column;
     * @param selectColumnValue the value of the specific column which is used to locate a specific row;
     * @return a sql statement which would be used to update this people in database;
     */
    public String updatePeople(String updateColumnName, String updateColumnValue, String selectColumnName,
                               String selectColumnValue) {
        return "update people set "+updateColumnName+" = \'"+updateColumnName+"\' where "+selectColumnName+" = \'"
                + selectColumnValue+ "\'";
    }

    public int getPeopleID() {
        return peopleID;
    }

    public void setPeopleID(int peopleID) {
        this.peopleID = peopleID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSpecial_accommodation() {
        return special_accommodation;
    }

    public void setSpecial_accommodation(String special_accommodation) {
        this.special_accommodation = special_accommodation;
    }
    public void printPeople() {
        String str = "people{ " + "people_id: " + peopleID +
            ", firstname: " + firstName +
            ", lastname: " + lastName +
            ", email: " + email +
            ", phonenumber: " + phoneNumber +
            ", password: " + password +
            ", profile: " + profile +
            ", special accommodation: " + special_accommodation + "}";
        System.out.println(str);
    }
    public String printPeopleToString() {
        return "people{ " + "people_id: " + peopleID +
                ", firstname: " + firstName +
                ", lastname: " + lastName +
                ", email: " + email +
                ", phonenumber: " + phoneNumber +
                ", password: " + password +
                ", profile: " + profile +
                ", special accommodation: " + special_accommodation + "}";
    }
    public static String peopleByID(String peopleID) {
        return "select * \n" +
                "from people\n" +
                "where people_id = " + peopleID;
    }
}
