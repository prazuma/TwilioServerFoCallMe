package com.appspot.helpme765pro;

import java.util.*;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.*; 
import com.twilio.sdk.resource.factory.*; 
import com.twilio.sdk.resource.instance.*; 
import com.twilio.sdk.resource.list.*; 

public class TwilioCall {
	 public static final String ACCOUNT_SID = "ACfd59bbf71338a29c46571829f6c9cbef"; 
	 public static final String AUTH_TOKEN = "3da6c5bf2e4a35233359459f132e38ab"; 
	 
	 public void call(String phoneNumber){ 
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
	 
		// Build the parameters 
		List<NameValuePair> params = new ArrayList<NameValuePair>(); 
		params.add(new BasicNameValuePair("To", phoneNumber)); 
		params.add(new BasicNameValuePair("From", "+81345408422")); 
		params.add(new BasicNameValuePair("Url", "http://helpme765pro.appspot.com/helpme765"));  
		params.add(new BasicNameValuePair("Method", "GET"));  
		params.add(new BasicNameValuePair("FallbackMethod", "GET"));  
		params.add(new BasicNameValuePair("StatusCallbackMethod", "GET"));    
		params.add(new BasicNameValuePair("Record", "false")); 
	 
		CallFactory callFactory = client.getAccount().getCallFactory(); 
		try {
			Call call = callFactory.create(params);
		} catch (TwilioRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 } 
}
