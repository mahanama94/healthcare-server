package lk.bhanuka.authentication;

import lk.bhanuka.DAO.UserDAO;
import lk.bhanuka.models.HealthOfficer;
import lk.bhanuka.models.User;

/**
 * Created by bhanuka on 12/11/16.
 */
public class Auth {

    private static User user = null;

    private static UserDAO userDAO = new UserDAO();

    private static boolean login(User user){
        if(user != null){
            Auth.user = user;
            return true;
        }
        return false;
    }

    public static boolean checkAuth(){
        if(Auth.user == null){
            return false;
        }
        return true;
    }

    public static User getUser(){
        return Auth.user;
    }

    public static boolean login(String token){

        System.out.println(token);

        String email = TokenGenerator.getEmail(token);
        System.out.println("email : " + email);
        if(Auth.userDAO.getUser(email)==null){
            return false;
        }

        Auth.login(Auth.userDAO.getUser(email));

        return true;
    }
}
