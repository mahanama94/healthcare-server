package lk.bhanuka.models;

/**
 * Created by bhanuka on 12/13/16.
 */
public class HealthOfficer extends User {

    public HealthOfficer(Long id, String name) {
        super(id, name);
    }

    public String getRole() {
        return "healthOfficer";
    }

    public int getAccessLevel() {
        return 10;
    }
}
