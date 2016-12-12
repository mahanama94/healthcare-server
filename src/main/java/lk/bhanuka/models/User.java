package lk.bhanuka.models;

/**
 * Created by bhanuka on 12/11/16.
 */
public abstract class User {

    protected Long id;

    protected String name;

    protected String dateOfBirth;

    protected District district;


    public User(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public abstract int getAccessLevel();

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth =dateOfBirth;
    }

    public void setDistrict(District district){
        this.district = district;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public abstract String getRole();

    public String getDateOfBirth(){ return this.dateOfBirth; }

    public District getDistrict(){ return this.district; }
}
