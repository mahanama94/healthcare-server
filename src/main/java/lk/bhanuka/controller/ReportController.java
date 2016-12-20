package lk.bhanuka.controller;

import lk.bhanuka.DAO.ReportDAO;
import lk.bhanuka.authentication.Auth;
import lk.bhanuka.models.Report;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bhanuka on 12/10/16.
 */
@RestController
public class ReportController {

	private ReportDAO reportDAO;

	public ReportController() {

		this.reportDAO = new ReportDAO();

	}

	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public List getReports() {
		String role = Auth.getUser().getRole();
		String nic = Auth.getUser().getNic();

		if (role == "patient") {
			ArrayList conditions = new ArrayList();
			// conditions.add("disease_name" + " LIKE '%"+ params.get("name")
			// +"%'");

			conditions.add("patient_nic" + " = '" + nic + "'");
			// return reportDAO.getReports()
			return reportDAO.findReports(conditions);
		} else {
			// System.out.println(role);
			return null;
		}

		// return this.reportDAO.getReports();
		// return role;

	}

	@RequestMapping(value = "/reports/search", method = RequestMethod.GET)
	public List findReports(HttpServletRequest request) {
		
		String role = Auth.getUser().getRole();
		
		if (role == "medical_officer" || role == "health_officer" || role == "patient"){
			HashMap params = new HashMap();

			params.put("name", request.getParameter("name"));

			ArrayList conditions = new ArrayList();
			String name = (String) params.get("name");
			 
			//conditions.add("patient_nic" + " LIKE '%" + params.get("patient_nic") + "%'");
			//conditions.add("(select nic from patient where name like %params.get(name)%)" + " LIKE '%" + params.get("patient_nic") + "%'");
			//conditions.add("patient_nic" + " LIKE '%" + params.get("patient_nic") + "%'");
			conditions.add("patient_nic" + " in " + "(select nic from patient where NAME like '%" + name + "%')");
			return reportDAO.findReports(conditions);
			
		}
		else{
			return null;
		}

	}
}
