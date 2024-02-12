package com.studentrecord.project.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

//public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) 
//      throws IOException {
//    	response.sendRedirect("www.google.com");
//        
//    }
//}


public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) 
      throws IOException {
    	response.setContentType("text/html;charset=UTF-8");  //http response to "text/html"
        PrintWriter out = response.getWriter();				//write text data to the response
        out.println("<script>alert('Authentication failed. Please check your credentials.');");
        out.println("window.location.href='/login';</script>");
    }
}
