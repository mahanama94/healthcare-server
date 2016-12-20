package lk.bhanuka.controller;

import lk.bhanuka.DAO.DiseaseDAO;
import lk.bhanuka.models.Disease;
import lk.bhanuka.validators.Validator;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/9/16
 */
@RestController
public class DiseaseController extends Controller{

	private DiseaseDAO diseaseDAO;

	public DiseaseController() {
		super();
		this.diseaseDAO = new DiseaseDAO();

	}

	@RequestMapping(value = "/diseases", method = RequestMethod.GET)
	public ArrayList getDiseases() {

		return this.diseaseDAO.diseaseList();

	}

	@RequestMapping(value = "/diseases/search", method = RequestMethod.GET)
	public List findDiseases(HttpServletRequest request) {
		
		
		HashMap params = new HashMap();
		
		params.put("name", request.getParameter("name"));
		params.put("description", request.getParameter("description"));
		
				
		ArrayList conditions = new ArrayList();

		conditions.add("disease_name" + " LIKE '%"+ params.get("name") +"%'");
		//conditions.add("description" + " LIKE '%"+ params.get("description") +"%'");
		
		return diseaseDAO.findDiseases(conditions);
	}

	@RequestMapping(value = "/diseases/{id}", method = RequestMethod.GET)
	public Disease getDisease(@PathVariable("id") Long id) {

		return this.diseaseDAO.getDisease(id);

	}

	@RequestMapping(value = "/diseases", method = RequestMethod.POST)
	public HashMap addDisease(HttpServletRequest request) {
		
		ArrayList<String> required = new ArrayList<String>();
		
		required.add("name");
        required.add("description");	
        required.add("treatment");
        required.add("symptoms");

		HashMap validated = this.validator.validate(request, required);
		
		if (validated.get("error") == null) {

			Disease newDisease = new Disease(0,
					request.getParameter("name"), request.getParameter("description"),
					request.getParameter("treatment"),
					request.getParameter("symptoms"));

				return this.diseaseDAO.addDisease(newDisease);
		}
		return validated;
	}

	@RequestMapping(value = "/diseases", method = RequestMethod.PUT)
	public HashMap updateDisease(HttpServletRequest request) {

		ArrayList<String> required = new ArrayList<String>();

		required.add("id");
		required.add("name");
		required.add("description");
		required.add("treatment");
		required.add("symptoms");

		if(this.validator.validate(request, required).get("error") == null){
			Disease disease = new Disease(Long.parseLong(request.getParameter("id")),
					request.getParameter("name"), request.getParameter("description"),
					request.getParameter("treatment"), request.getParameter("symptoms"));

			return this.diseaseDAO.updateDisease(disease);
		}
		else {

			return this.validator.validate(request, required);
		}

	}

}
