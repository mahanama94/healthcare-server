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

    private String password;

    public UserDAO(){
        super();
        this.tableName = "user";
        this.primaryKey = "email";
        this.password = "password";
    }

    public User getUser(String email, String password){

        ArrayList<String> conditions = new ArrayList<>();

        conditions.add(this.primaryKey + " = '"+ email+"'");
        conditions.add(this.password + " = '"+ password+"'");

        List<HashMap> response = this.dataService.get(this.tableName, conditions);

        for(HashMap element : response){

            User user =  this.createUser(element);
            user.setEmail(email);
            return user;
        }

        return null;
    }

    public User getUser(String email){

        ArrayList<String> conditions = new ArrayList<>();

        conditions.add(this.primaryKey + " = '"+ email+"'");

        List<HashMap> response = this.dataService.get(this.tableName, conditions);

        for(HashMap element : response){

            User user =  this.createUser(element);
            user.setEmail(email);

            return user;
        }

        return null;
    }

    private User createUser(HashMap element){

        System.out.println(element.toString());

        if(element.get("role") == "healthOfficer"){
            return new HealthOfficer(1, "Health Officer");
        }
        else if(element.get("role") == "medicalOfficer"){
            return new MedicalOfficer(1, "Medical Officer");
        }

        return new Patient(1, "Patient NIC", "Patient Name", "Date of birth", 5);
    }

}
