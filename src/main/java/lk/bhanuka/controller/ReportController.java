package lk.bhanuka.controller;

import lk.bhanuka.DAO.ReportDAO;
import lk.bhanuka.models.Report;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by bhanuka on 12/10/16.
 */
@RestController
public class ReportController {

    private ReportDAO reportDAO = new ReportDAO();

    @RequestMapping(value = "/reports", method = RequestMethod.GET)
    public List getReports(){
        return  this.reportDAO.getReports();
    }

    @RequestMapping( value = "/report/{id}", method = RequestMethod.GET)
    public Report getReport(@PathVariable("id") Long id){

        return this.reportDAO.getReport(id);

    }
}
