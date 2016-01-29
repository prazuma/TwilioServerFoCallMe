package com.appspot.helpme765pro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TwilioCallServlet extends HttpServlet{
	public static final String ACCOUNT_SID = "AC1cb03172476fa4e79be4a16d86a78e39"; 
	public static final String AUTH_TOKEN = "30be8a42650a38a4b58c17095d34a2a5";
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		TwilioCall twiCall = new TwilioCall();
		twiCall.call("+819038185351");

	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html; charset=UTF-8");
		String phoneNumber = req.getParameter("phoneNumber");
		String internationalPhoneNumber = createJaPhoneNumber(phoneNumber);
		TwilioCall twiCall = new TwilioCall();
		twiCall.call(internationalPhoneNumber);
		
		resp.sendRedirect("sendPhoneNumber.html");
	}
	
	/*
	 * Creates international phone number for Japan.
	 * e.g., 03-1234-5678 -> +81312345678
	 * @param phoneNumber: domestic phone number
	 * @return international phone number
	 */
	public String createJaPhoneNumber(String phoneNumber) {
		return "+81" + phoneNumber.substring(1);
	}
}
