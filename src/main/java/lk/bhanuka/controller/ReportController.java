package lk.bhanuka.controller;

import lk.bhanuka.DAO.ReportDAO;
import lk.bhanuka.authentication.Auth;
import lk.bhanuka.models.Disease;
import lk.bhanuka.models.Report;
import lk.bhanuka.validators.Validator;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bhanuka on 12/10/16.
 */
@RestController
public class ReportController extends Controller {

	private ReportDAO reportDAO;

	public ReportController() {
		super();
		this.reportDAO = new ReportDAO();

	}

	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public List getReports() {
		String role = Auth.getUser().getRole();
		String nic = Auth.getUser().getNic();

		if (role == "patient") {
			ArrayList conditions = new ArrayList();

			conditions.add("patient_nic" + " = '" + nic + "'");

			return reportDAO.findReports(conditions);
		} else {

			return null;
		}
	}

	@RequestMapping(value = "/reports/search", method = RequestMethod.GET)
	public List findReports(HttpServletRequest request) {

		String role = Auth.getUser().getRole();

		if (role == "medical_officer" || role == "health_officer" || role == "patient") {
			HashMap params = new HashMap();

			params.put("name", request.getParameter("name"));

			ArrayList conditions = new ArrayList();
			String name = (String) params.get("name");

			conditions.add("patient_nic" + " in " + "(select nic from patient where NAME like '%" + name + "%')");
			return reportDAO.findReports(conditions);

		} else {
			return null;
		}

	}


	@RequestMapping(value = "/reports", method = RequestMethod.POST)
	public HashMap addDisease(HttpServletRequest request) {

		ArrayList<String> required = new ArrayList<String>();

		required.add("disease_id");
		required.add("patient_nic");

		String med_officer_nic = Auth.getUser().getNic();

		HashMap validated = this.validator.validate(request, required);

		if (validated.get("error") == null) {
			Report report = new Report();
			report.setPatient_nic(request.getParameter("patient_nic"));
			report.setDisease_id(Long.parseLong(request.getParameter("disease_id")));
			report.setMed_officer_nic(med_officer_nic);
			return this.reportDAO.addReport(report);
		}
		return validated;
	}

	@RequestMapping(value = "/reports", method = RequestMethod.PUT)
	public HashMap updateDisease(HttpServletRequest request) {

		String patient_nic = request.getParameter("patient_nic");
		String med_officer_nic = request.getParameter("med_officer_nic");
		Long disease_id = Long.parseLong(request.getParameter("disease_id"));
		String last_updated_by = Auth.getUser().getNic();

		String comments = request.getParameter("comments");
		String prescription = request.getParameter("prescription");

		Report report = new Report();

		report.setPatient_nic(patient_nic);
		report.setMed_officer_nic(med_officer_nic);
		report.setComments(comments);
		report.setPrescription(prescription);
		report.setDisease_id(disease_id);
		report.setLast_updated_by(last_updated_by);

		return reportDAO.updateReport(report);

	}

}
