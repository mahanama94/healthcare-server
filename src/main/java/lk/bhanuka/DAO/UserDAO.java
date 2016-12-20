package lk.bhanuka.DAO;

import lk.bhanuka.models.HealthOfficer;
import lk.bhanuka.models.MedicalOfficer;
import lk.bhanuka.models.Patient;
import lk.bhanuka.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/15/16.
 */
public class UserDAO extends DAO {

    private String password = "pwd";

    private String role = "role";

    private MedicalOfficerDAO medicalOfficerDAO = new MedicalOfficerDAO();

    private PatientDAO patientDAO = new PatientDAO();

    public UserDAO(){
        super();
        this.tableName = "users";
        this.primaryKey = "nic";
    }

    public User getUser(String nic, String password){

        ArrayList<String> conditions = new ArrayList<>();

        conditions.add(this.primaryKey + " = '"+ nic +"'");
        conditions.add(this.password + " = '"+ password+"'");

        List<HashMap> response = this.dataService.get(this.tableName, conditions);

        if(response != null) {


            for (HashMap element : response) {

                User user = this.createUser(element);
                return user;
            }
        }

        return null;
    }

    public User getUser(String nic){

        ArrayList<String> conditions = new ArrayList<>();

        conditions.add(this.primaryKey + " = '"+ nic +"'");

        List<HashMap> response = this.dataService.get(this.tableName, conditions);

        for(HashMap element : response){

            User user =  this.createUser(element);

            return user;
        }

        return null;
    }

    public HashMap addUser(HashMap credentials){

//        if(credentials.get("role") == "healthOfficer"){
//            return this.medicalOfficerDAO.addMedicalOfficer();
//        }
//        if(credentials.get("role") == "medicalOfficer"){
//            return this.medicalOfficerDAO.addMedicalOfficer();
//        }
        return this.patientDAO.addPatient(credentials);

//        return this.patientDAO.getPatient("0123456789");


    }

    private User createUser(HashMap element){

        System.out.println(element.toString());

        if(element.get(this.role) == "healthOfficer"){
            return this.medicalOfficerDAO.getMedicalOfficer(Integer.toUnsignedLong(10));
        }
        else if(element.get("role") == "medicalOfficer"){
            return this.medicalOfficerDAO.getMedicalOfficer(element.get("nic").toString());
        }

        return this.patientDAO.getPatient(element.get("nic").toString());
    }

}
