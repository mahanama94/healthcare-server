package lk.bhanuka.models;

/**
 * Created by bhanuka on 12/9/16.
 */
public class MedicalOfficer extends User{

    public MedicalOfficer(long id, String name){
        super(id, name);
    }

    public String getRole() {
        return "medicalOfficer";
    }

    public int getAccessLevel() {
        return 5;
    }
}
