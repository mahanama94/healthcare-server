package lk.bhanuka.controller;

import lk.bhanuka.validators.Validator;

/**
 * Created by bhanuka on 12/15/16.
 */
public abstract class Controller {

    protected Validator validator;

    public Controller(){

        this.validator = new Validator();
    }

}
