package lk.bhanuka.models;

/**
 * Created by bhanuka on 12/13/16.
 */
public abstract class Region {

    private Long id;

    private String name;

    public Region(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId(){ return this.id; }

    public String getName(){ return this.name; }
}
