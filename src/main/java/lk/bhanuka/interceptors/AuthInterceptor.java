package lk.bhanuka.interceptors;

import lk.bhanuka.authentication.Auth;
import lk.bhanuka.authentication.Authenticator;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bhanuka on 12/11/16.
 */
public class AuthInterceptor implements HandlerInterceptor{

    private Authenticator authenticator;

    public AuthInterceptor(){

        this.authenticator = new Authenticator();

    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        response.setContentType("application/json");

        if( ! this.authenticator.checkAuth(request)){

            this.handleNonAuthenticated(response);

            return false;

        }

//        if(Auth.getUser()!= null){
//            System.out.println("Role" + Auth.getUser().getRole());
//        }

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private void handleNonAuthenticated(HttpServletResponse response){

        try {
            response.setContentType("application/json");
            response.sendError(401, "Not authorized");
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
