package lk.bhanuka.models;

/**
 * Created by bhanuka on 12/9/16.
 */
public class Patient extends User{

    private String address;

    public Patient(Long id, String name){
        super(id, name);
    }

    public Patient(Long id, String name, String address){
        super(id, name);
        this.address = address;
    }

    public String getAddress(){
        return this.address;
    }

    public String getRole() {
        return "patient";
    }

    public int getAccessLevel() {
        return 0;
    }
}
