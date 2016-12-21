package lk.bhanuka.models;

import lk.bhanuka.DAO.DiseaseDAO;
import lk.bhanuka.DAO.MedicalOfficerDAO;
import lk.bhanuka.DAO.PatientDAO;

/**
 * Created by bhanuka on 12/10/16.
 */
public class Report {

	private PatientDAO patientDAO = new PatientDAO();
	private MedicalOfficerDAO medicalOfficerDAO = new MedicalOfficerDAO();
	private DiseaseDAO diseaseDAO = new DiseaseDAO();

	private String last_updated = null;
	private String comments = null;
	private String med_officer_nic = null; // should get med_officer_name from
											// this
	private String med_officer_name;
	private Long disease_id = null; // should get disease name from this
	private String disease_name;
	private String patient_nic = null;// should get patient name from this
	private String patient_name;
	private String prescription = null;
	private String report_date = null;

	public Report() {

	}

	// Basic Setters \\

	public void setMed_officer_name(String med_officer_name) {
		this.med_officer_name = med_officer_name;
	}

	public void setDisease_name(String disease_name) {
		this.disease_name = disease_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setMed_officer_nic(String med_officer_nic) {
		this.med_officer_nic = med_officer_nic;
		med_officer_name = medicalOfficerDAO.getMedicalOfficer(med_officer_nic).getName();
	}

	public void setDisease_id(Long disease_id) {
		this.disease_id = disease_id;
		disease_name = diseaseDAO.getDisease(disease_id).getName();
	}

	public void setPatient_nic(String patient_nic) {
		this.patient_nic = patient_nic;
		patient_name = patientDAO.getPatient(patient_nic).getName();
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}

	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}

	// Basic Getters \\

	public String getPatient_nic() {
		return patient_nic;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public String getMed_officer_name() {
		return med_officer_name;
	}

	public String getMed_officer_nic() {
		return med_officer_nic;
	}

	public Long getDisease_id() {
		return disease_id;
	}

	public String getDisease_name() {
		return disease_name;
	}

	public String getComments() {
		return comments;
	}

	public String getPrescription() {
		return prescription;
	}

	public String getReport_date() {
		return report_date;
	}

	public String getLast_updated() {
		return last_updated;
	}

	// Basic setters and Getters \\

}