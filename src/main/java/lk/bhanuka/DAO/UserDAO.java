package lk.bhanuka.DAO;

import lk.bhanuka.models.HealthOfficer;
import lk.bhanuka.models.MedicalOfficer;
import lk.bhanuka.models.Patient;
import lk.bhanuka.models.User;
import org.springframework.security.crypto.bcrypt.BCrypt;

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
//        conditions.add(this.password + " = '"+ BCrypt.hashpw(password, BCrypt.gensalt())+"'");

        List<HashMap> response = this.dataService.get(this.tableName, conditions);

        if( ! BCrypt.checkpw(password, response.get(0).get("pwd").toString())){
            return null;
        }

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
        HashMap returnList = new HashMap();

        if(credentials.get("role").toString().equals("medical_officer")){
            returnList.put("user", this.medicalOfficerDAO.addMedcicalOfficer(credentials).get("medicalOfficer"));

        }
        else {
            returnList.put("user", this.patientDAO.addPatient(credentials).get("patient"));
        }

        return returnList;


    }

    private User createUser(HashMap element){

        //System.out.println("ROLE : " + element.get("role").toString());

        if(element.get(this.role) == "health_officer"){
            return this.medicalOfficerDAO.getMedicalOfficer(Integer.toUnsignedLong(10));
        }
        else if(element.get("role").toString().equals("medical_officer")){
            //System.out.println("medical_officer created ");
            return this.medicalOfficerDAO.getMedicalOfficer(element.get("nic").toString());
        }
        //System.out.println("patient created ");
        return this.patientDAO.getPatient(element.get("nic").toString());
    }

}
