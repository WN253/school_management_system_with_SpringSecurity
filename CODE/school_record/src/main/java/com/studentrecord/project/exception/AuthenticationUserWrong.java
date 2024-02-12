package com.studentrecord.project.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class AuthenticationUserWrong implements AccessDeniedHandler {

	 @Override
	    public void handle(HttpServletRequest request, HttpServletResponse response,
	                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
	        // Customize the error message here
	        String errorMessage = "Access denied. You have no Access.";

	        // Set the response status and write the error message to the response
	        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	        response.getWriter().write(errorMessage);
	    }
}
