package lk.bhanuka.DAO;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by bhanuka on 12/20/16.
 */
public class PatientDAOTest {

    private  PatientDAO patientDAO= new PatientDAO();
    @Test
    public void getPatients() throws Exception {

    }

    @Test
    public void getPatient() throws Exception {

    }

    @Test
    public void getPatient1() throws Exception {

    }

    @Test
    public void findPatients() throws Exception {

    }

    @Test
    public void addPatient() throws Exception {

        HashMap credentials = new HashMap();
        credentials.put("nic", "9876543210");
        credentials.put("name", "test");
        credentials.put("password", "some");
        credentials.put("district_id", 1);
        credentials.put("dob","1994-05-05");
        credentials.put("role", "patient");

        HashMap response = this.patientDAO.addPatient(credentials);
        System.out.println(response.toString());
    }

    @Test
    public void addPatient1() throws Exception {

    }

}