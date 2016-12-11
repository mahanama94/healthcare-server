package lk.bhanuka.interceptors;

import com.sun.org.apache.xpath.internal.operations.Bool;
import junit.framework.Test;
import lk.bhanuka.authentication.Authenticator;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by bhanuka on 12/11/16.
 */
public class AuthInterceptor implements HandlerInterceptor{

    private Authenticator authenticator;

    public AuthInterceptor(){

        this.authenticator = new Authenticator();

    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if( ! this.authenticator.checkAuth(request)){

            this.handleNonAuthenticated(response);

            return false;

        }

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private void handleNonAuthenticated(HttpServletResponse response){
        // TODO - Handle non authenticated requests
    }

}
