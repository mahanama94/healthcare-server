package lk.bhanuka.models;

/**
 * Created by bhanuka on 12/9/16.
 */
public class Disease {

    private Long id;

    private String name;

    private String description;

    private String treatment;

    public Disease(long id, String name){
        this.id = id;
        this.name = name;
    }

    public Disease(long id, String name, String description, String treatment){
        this(id, name);
        this.description = description;
        this.treatment = treatment;
    }

    public void setTreatment(String treatment){ this.treatment = treatment; }

    public void setDescription(String description){ this.description = description; }

    public long getId(){
        return  this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){ return this.description; }

    public String getTreatment(){ return this.treatment; }
}