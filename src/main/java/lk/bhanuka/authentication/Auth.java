package lk.bhanuka.authentication;

import com.sun.org.apache.bcel.internal.generic.INEG;
import lk.bhanuka.models.HealthOfficer;
import lk.bhanuka.models.User;

import java.util.InputMismatchException;

/**
 * Created by bhanuka on 12/11/16.
 */
public class Auth {

    private static User user = null;

    public static boolean login(User user){
        if(user != null){
            Auth.user = user;
            return true;
        }
        return false;
    }

    public static boolean checkAuth(){
//        if(Auth.user == null){
//            return false;
//        }
        return true;
    }

    public static User getUser(){

        return new HealthOfficer((long) 15, "some name");

        //return Auth.user;
    }
}
