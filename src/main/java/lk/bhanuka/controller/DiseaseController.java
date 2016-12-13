package lk.bhanuka.controller;

import lk.bhanuka.DAO.DiseaseDAO;
import lk.bhanuka.models.Disease;
import lk.bhanuka.validators.NewDiseaseValidator;
import lk.bhanuka.validators.UpdateDiseaseValidator;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/9/16.
 */
@RestController
public class DiseaseController {

	private DiseaseDAO diseaseDAO;

	private NewDiseaseValidator newDiseaseValidator;

	private UpdateDiseaseValidator updateDiseaseValidator;

	public DiseaseController() {

		this.diseaseDAO = new DiseaseDAO();

		this.newDiseaseValidator = new NewDiseaseValidator();

		this.updateDiseaseValidator = new UpdateDiseaseValidator();
	}

	@RequestMapping(value = "/diseases", method = RequestMethod.GET)
	public List getDiseases() {

		return this.diseaseDAO.diseaseList();

	}

	@RequestMapping(value = "/diseases/search", method = RequestMethod.GET)
	public List findDiseases() {

		return this.diseaseDAO.diseaseList();

	}

	@RequestMapping(value = "/diseases/{id}", method = RequestMethod.GET)
	public Disease getDisease(@PathVariable("id") Long id) {

		return this.diseaseDAO.getDisease(id);

	}

	@RequestMapping(value = "/diseases", method = RequestMethod.POST)
	public HashMap addDisease(HttpServletRequest request) {

		HashMap validated = newDiseaseValidator.validate(request);

		if (validated.get("error") == null) {
//			Disease newDisease = new Disease(Long.parseLong(request.getParameter("id"), 10),
//					request.getParameter("name"), request.getParameter("description"),
//					request.getParameter("treatment"));
			
			Disease newDisease = new Disease(
					request.getParameter("name"), request.getParameter("description"),
					request.getParameter("treatment"));


			// after validation check for DB violations
			Object violated = diseaseDAO.addDisease(newDisease);
			// System.out.println(violated.getClass());

			if (violated instanceof String) {
				// System.out.println("violated");
				HashMap error = new HashMap();
				error.put("error", (String) violated);
				// System.out.println(error);
				return error;
			} else {
				return (HashMap) violated;
			}

		}
		return validated;

	}

	@RequestMapping(value = "/diseases", method = RequestMethod.PUT)
	public HashMap updateDisease(HttpServletRequest request) {
		
		// TODO This is not functioning
		return this.updateDiseaseValidator.validate(request);

	}

}
