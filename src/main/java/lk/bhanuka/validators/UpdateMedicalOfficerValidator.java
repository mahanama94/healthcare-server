package lk.bhanuka.validators;

import java.util.ArrayList;

/**
 * Created by bhanuka on 12/13/16.
 */
public class UpdateMedicalOfficerValidator extends Validator {

    public UpdateMedicalOfficerValidator(){

        this.required = new ArrayList<String>();

        this.accessLevel = 10;
    }
}
