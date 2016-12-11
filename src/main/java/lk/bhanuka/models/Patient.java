package lk.bhanuka.models;

/**
 * Created by bhanuka on 12/9/16.
 */
public class Patient {

    private Long id;

    private String name;

    private String address;

    public Patient(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Patient(Long id, String name, String address){
        this.id =id;
        this.name = name;
        this.address = address;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }
}
