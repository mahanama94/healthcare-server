package lk.bhanuka.validators;

import lk.bhanuka.authentication.Auth;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bhanuka on 12/12/16.
 */
public class NewPatientValidator extends Validator {

    public NewPatientValidator(){

        this.required = new ArrayList<String>();

        required.add("name");

        this.accessLevel = 5;

    }

}
