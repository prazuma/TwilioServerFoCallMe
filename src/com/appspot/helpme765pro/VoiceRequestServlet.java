package com.appspot.helpme765pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VoiceRequestServlet extends HttpServlet{
	public static final String USER_NAME = "MA11WebAPIJ";
	public static final String PASSWORD = "tRWjUhJB";
	public static final String REQUEST_URL = "http://webapi.aitalk.jp/webapi/v1/ttsget.php";
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String text = req.getParameter("voice_text");
		String volume = req.getParameter("volume");
		String speed = req.getParameter("speed");
		String pitch = req.getParameter("pitch");
		String range = req.getParameter("range");
		String url = String.format("%s?username=%s&password=%s&ext=wav&speaker_id=701&volume=%s&speed=%s&pitch=%s&range=%s&text=%s",
								   REQUEST_URL, USER_NAME, PASSWORD, volume, speed, pitch, range, text);
		PrintWriter out = resp.getWriter();
		out.println("<html><body><a href="+url+">click here</a></body></html>");
	}
}
