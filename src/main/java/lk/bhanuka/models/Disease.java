package lk.bhanuka.models;

/**
 * Created by bhanuka on 12/9/16
 */
public class Disease {

	private Long id;
	
    private String name;

    private String description;

    private String treatment;

    private String symptoms;

    public Disease(long id, String name, String description, String treatment, String symptoms){
        this.id = id;
        this.name = name;
        this.description = description;
        this.treatment = treatment;
        this.symptoms = symptoms;
    }

    public void setId(Long id){ this.id = id; }
    
    public void setTreatment(String treatment){ this.treatment = treatment; }
    
    public void setDescription(String description){ this.description = description; }
    
    public long getId(){return id;}
    
    public String getName(){return this.name;}
    
    public String getDescription(){ return this.description; }
    
    public String getTreatment(){ return this.treatment; }

    public String getSymptoms(){ return this.symptoms; }

    public String getUpdateDate(){ return "2016-12-15"; }
    // TODO: For testing
	@Override
	public String toString() {
		return "Disease [id=" + id + ", name=" + name + ", description=" + description + ", treatment=" + treatment
				+ "]";
	}
    
    
 }
