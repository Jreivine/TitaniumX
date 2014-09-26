/**
 * @FileName: UserLogin.java
 * 
 * @authore Waeal J.Obidallah <Wobidallah@uoattwa.ca>
 *  
 * Created on Sep 25, 2014 -  6:22:48 PM
 *
 */
package com.titanium.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin.do")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        //here we would put some logic to validate the user.
				//simulate the database not sure how we will use the WS to commincate with DBAGENT lets figure it out later
				String uid = "authorizeduser";
				int authLevel = 1;
				 /*
				 *assuming the user is valid, let's set some information into session
				 *in this way, ALL jsp pages and servlets going forward can access the value
				 *to start a session, get the session from the request into a variable
				 */
				HttpSession s = request.getSession();
				s.setAttribute("userName", uid);
				s.setAttribute("userAuthLevel", authLevel);
				
				//redirect when unauthorized notification
				if (authLevel < 1 || uid == null || uid == "")
				{
                    // session id in URL no need for cookies enabling 					
					response.sendRedirect(response.encodeRedirectURL("Login.html"));
					
				}
				else
				{
					//forward to requested page or menu page/home page with authorization
					response.sendRedirect(response.encodeRedirectURL("/TitaniumXCdStore/destinationpage.do"));
					
				}
		
		
		
	}

}
