package lk.bhanuka.controller;

import lk.bhanuka.validators.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bhanuka on 12/15/16.
 */
public abstract class Controller {

    protected Validator validator;

    public Controller(){

        this.validator = new Validator();
    }

    protected HashMap validate(HttpServletRequest request, ArrayList<String> required){

        return this.validator.validate(request, required);

    }

}
