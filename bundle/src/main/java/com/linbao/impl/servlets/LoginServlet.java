package com.linbao.impl.servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.linbao.utils.StringUtil;

@SlingServlet(paths="/bin/linbao/login", methods="GET",extensions={"html","json"})
@Model(adaptables=SlingHttpServletRequest.class)
public class LoginServlet extends SlingAllMethodsServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger logging = LoggerFactory.getLogger(LoginServlet.class);
	
	private static final int PARAM_VAILD = 1;
	private static final int PARAM_INVAILD = 0;
	
	private int status = -1;
	private String username = null; 
	private String password = null;

	public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException{
		logging.debug("doGet method is called");
		doPost(request, response);
	}
	public void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException{
		
		username = (String) request.getParameter("username");
		password = (String) request.getParameter("password");
		
		logging.info("get username & password from parameter: username = " + username + " and password = " + password );
		if(StringUtil.isEmpty(username) || StringUtil.isEmpty(password)){
			status = 0;
		}else{
			status = 1;
		}
		buildResponse(request,response);
	}
	
	private void buildResponse(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,IOException{
		
		if(PARAM_INVAILD == status){
			response.getWriter().print("Sorry, your username or password is invaild");
		}else if(PARAM_VAILD == status){
			response.getWriter().print("Hello "+ username + ", welcome to AEM !");
		}
	}
	
	
}
