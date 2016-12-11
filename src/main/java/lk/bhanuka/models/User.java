package lk.bhanuka.models;

/**
 * Created by bhanuka on 12/11/16.
 */
public abstract class User {

    protected Long id;

    protected String name;

    public User(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public abstract String getRole();
}
