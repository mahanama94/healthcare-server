package lk.bhanuka.models;

/**
 * Created by bhanuka on 12/13/16.
 */
public class HealthOfficer extends User {

    public HealthOfficer(Long id, String name) {
        //super(id, name);
    }

    public void setProvince(Province province){
        //this.region = province;
    }

    public String getRole() {
        return "healthOfficer";
    }

    public int getAccessLevel() {
        return 10;
    }

//    public Province getProvince(){ return (Province)this.region; }
}
