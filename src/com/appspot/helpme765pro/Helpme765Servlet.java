package com.appspot.helpme765pro;

import java.io.IOException;
import javax.servlet.http.*;

import com.twilio.sdk.verbs.Play;
import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

@SuppressWarnings("serial")
public class Helpme765Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		TwiMLResponse twiml = new TwiMLResponse();
		Play play = new Play("http://helpme765pro.appspot.com/voicetext_test.wav");
		try {
			twiml.append(play);
		} catch (TwiMLException e) {
			e.printStackTrace();
		}
		resp.setContentType("application/xml");
		resp.getWriter().print(twiml.toXML());
	}
}
