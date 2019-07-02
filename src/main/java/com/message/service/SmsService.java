package com.message.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Path("/message/")
public class SmsService {

	@Path("/sendSms")
	@POST
	public Response sendSms(@QueryParam("mbl") String mobile, @QueryParam("text") String text) {
		
		RestTemplate rt = new RestTemplate();

		String url = "https://api.textlocal.in/send?";
		url = url.concat("apiKey=").concat("gQlRv2snAak-kSi4acq1NxRQmS9IKFK4rFGfa23s9e");
		url = url.concat("&sender=").concat("TXTLCL");
		url = url.concat("&numbers=").concat(mobile);
		url = url.concat("&message=").concat(text);
		

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<String> response = rt.exchange(url, HttpMethod.POST, entity, String.class);
		System.out.println("Response Data : " + response.getBody());
		
		return Response.status(200).entity(response.getBody()).build();
	}
}
