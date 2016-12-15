package lk.bhanuka.controller;

import lk.bhanuka.DAO.ReportDAO;
import lk.bhanuka.models.Report;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by bhanuka on 12/10/16.
 */
@RestController
public class ReportController {

    private ReportDAO reportDAO;

    public ReportController(){

        this.reportDAO = new ReportDAO();

    }

    @RequestMapping(value = "/reports", method = RequestMethod.GET)
    public List getReports(){

        return  this.reportDAO.getReports();

    }

    @RequestMapping( value = "/reports/{patientId}/{medicalOfficerId}/{diseaseId}", method = RequestMethod.GET)
    public Report getReport(@PathVariable("patientId") Long patientId, @PathVariable("medicalOfficerId") Long medicalOfficerId, @PathVariable("diseaseId") Long diseaseId){

        System.out.println(patientId);

        System.out.println(medicalOfficerId);

        System.out.println(diseaseId);

        return null;

    }
}
