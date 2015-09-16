package com.linbao.impl.servlets;

import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class LoginServletTest {

	private SlingHttpServletRequest request = null;
	private SlingHttpServletResponse response = null;
	@Before
	public void before() throws IOException{
		request = Mockito.mock(SlingHttpServletRequest.class);
		response = Mockito.mock(SlingHttpServletResponse.class);
		PrintWriter pw = Mockito.mock(PrintWriter.class);
		Mockito.when(response.getWriter()).thenReturn(pw);
		
	}
	@Test
	public void loginTest() throws ServletException, IOException{
		
		LoginServlet ls = mock(LoginServlet.class);
		ls.doGet(request, response);
		Mockito.verify(response.getWriter(),Mockito.never()).print("");
	}
}
