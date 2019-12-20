package Objects;

/**
 * A Table to connect the many-to-many people with their respective blocs.
 */

public class blocPeopleRelation {
    private int people_id;
    private int bloc_id;

    public blocPeopleRelation(int people_id, int bloc_id) {
        this.people_id = people_id;
        this.bloc_id = bloc_id;
    }

    public int getPeople_id() {
        return people_id;
    }

    public void setPeople_id(int people_id) {
        this.people_id = people_id;
    }

    public int getBloc_id() {
        return bloc_id;
    }

    public void setBloc_id(int bloc_id) {
        this.bloc_id = bloc_id;
    }

    public static String getAllPeopleInBloc(String bloc_id) {
        return "select * from people where people_id in (select people_id from bloc_people_relation where bloc_id = "+bloc_id+")";
    }

    public String insert() {
        return "insert into bloc_people_relation values ("+people_id+", "+bloc_id+")";
    }

    public String delete() {
        return "delete from bloc_people_relation where people_id = "+people_id+" and bloc_id = "+bloc_id;
    }

}
