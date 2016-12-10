package lk.bhanuka.models;

/**
 * Created by bhanuka on 12/9/16.
 */
public class Disease {

    private Long id;
    private String name;

    public Disease(long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId(){
        return  this.id;
    }

    public String getName(){
        return this.name;
    }

}
