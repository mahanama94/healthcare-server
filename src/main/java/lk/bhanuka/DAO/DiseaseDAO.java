package lk.bhanuka.DAO;

import lk.bhanuka.models.Disease;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/9/16.
 */
@Component
public class DiseaseDAO extends DAO {

	/**
	 * Column names
	 */

	private String name = "disease_name";

	private String description = "description";

	private String treatment = "treatment";

	public DiseaseDAO() {
		super();
		this.tableName = "disease";
		this.primaryKey = "disease_id";

	}

	public List<Disease> diseaseList() {

		return this.findDiseases(new ArrayList());

	}

	public Disease getDisease(long id) {

		ArrayList<String> conditions = new ArrayList<String>();

		conditions.add(this.primaryKey + " = " + Long.toString(id));

		List<HashMap> results = this.dataService.get(this.tableName, conditions);

		if (results != null) {

			for (HashMap element : results) {

				return this.createDisease(element);

			}

		}

		return null;

	}

	public List<Disease> findDiseases(ArrayList conditions) {

		ArrayList<Disease> diseases = new ArrayList<Disease>();

		List<HashMap> results = this.dataService.get(this.tableName, conditions);

		for (HashMap element : results) {

			Disease disease = this.createDisease(element);

			diseases.add(disease);

		}

		return diseases;

	}

	public HashMap addDisease(Disease disease) {

		HashMap values = new HashMap();

		values.put(this.name, disease.getName());
		values.put(this.description, disease.getDescription());
		values.put(this.treatment, disease.getTreatment());

		HashMap response = this.dataService.insert(this.tableName, values);

		HashMap results =  new HashMap();

		if(response.get("error") == null){

			response.put(this.primaryKey, response.get("GENERATED_KEY"));


			results.put("disease",this.createDisease(response));
		}
		else{

			results.put("error", response.get("error"));

		}
		return results;

	}

	private Disease createDisease(HashMap element) {

		Disease newDisease = new Disease(Long.valueOf(element.get(this.primaryKey).toString()),
				element.get(this.name).toString());

		try {
			newDisease.setDescription(element.get(this.description).toString());

			newDisease.setTreatment(element.get(this.treatment).toString());
		} catch (Exception e) {

			System.out.println("Exception");

		} finally {

			return newDisease;

		}

	}

}