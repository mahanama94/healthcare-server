package lk.bhanuka.DAO;

import lk.bhanuka.models.Disease;
import lk.bhanuka.models.MedicalOfficer;
import lk.bhanuka.models.Report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

/**
 * Created by bhanuka on 12/10/16.
 */
public class ReportDAO extends DAO {

	public ReportDAO() {
		super();
		PatientDAO patientDAO = new PatientDAO();
		this.tableName = "med_report";

	}

	public List<Report> getReports() {

		return this.findReports(new ArrayList<String>());

	}

	public List<Report> findReports(ArrayList<String> conditions) {

		ArrayList<Report> reports = new ArrayList<Report>();

		List<HashMap> results = this.dataService.get(this.tableName, conditions);
		System.out.println(results);

		for (HashMap element : results) {

			Report report = new Report();

			// report.setReport_date((String)element.get("report_date"));
			report.setPatient_nic((String) element.get("patient_nic"));
			report.setMed_officer_nic((String) element.get("med_officer_nic"));
			report.setDisease_id((Long) element.get("disease_id"));
			report.setComments((String) element.get("comments"));
			report.setPrescription((String) element.get("prescriptions"));
			// report.setLast_updated((String)element.get("last_updated"));

			reports.add(report);

		}

		return reports;
	}

	public HashMap addReport(Report report) {

		HashMap values = new HashMap();

		values.put("patient_nic", report.getPatient_nic());
		values.put("disease_id", report.getDisease_id());
		values.put("med_officer_nic", report.getMed_officer_nic());

		HashMap response = this.dataService.insert(this.tableName, values);

		HashMap results = new HashMap();

		if (response.get("error") == null) {

			return response;

		} else {
			results.put("error", response.get("error"));
			return results;
		}

	}

	public HashMap updateReport(Report report) {

		HashMap values = new HashMap();
		values.put("comments", report.getComments());
		values.put("prescriptions", report.getPrescription());
		values.put("last_updated_by", report.getLast_updated_by());

		ArrayList conditions = new ArrayList();
		conditions.add("patient_nic" + " = '" + report.getPatient_nic() + "'");
		conditions.add("med_officer_nic" + " = '" + report.getMed_officer_nic() + "'");
		conditions.add("disease_id" + " = '" + report.getDisease_id() + "'");

		System.out.println("conditions ");
		System.out.println(conditions.toString());

		HashMap response = this.dataService.update(this.tableName, values, conditions);

		HashMap results = new HashMap();

		System.out.println(response.toString());

		if (response.get("error") == null) {
			return response;
		}

		else {
			results.put("error", response.get("error"));
			return results;
		}

	}

}
