package com.confianza.webapp.controller.framework.captcha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import net.tanesha.recaptcha.ReCaptchaImpl;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import sun.net.www.http.HttpClient;

import com.google.gson.Gson;

@Controller
public class GoogleReCaptchaController {

	@Autowired
    ReCaptchaImpl reCaptcha;	
	
	@Autowired
	Gson gson;
	
	@RequestMapping(value = "/validateReCaptcha", method = RequestMethod.POST, produces={"application/json"})
	@ResponseBody
    public String validateCaptcha( ServletRequest servletRequest, @RequestParam("g_recaptcha") String g_recaptcha) throws Exception
    {		
		String remoteAddress = servletRequest.getRemoteAddr();
		String urlu = "https://www.google.com/recaptcha/api/siteverify?secret=6Ld7av4SAAAAAPqyLaN63Q2qNBZVu1-ESWUvUjLq&response="+g_recaptcha+"&user_ip_address="+remoteAddress;		
		
		URL url = new URL(urlu);
		
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);

		httpCon.setDoInput(true);

		httpCon.setRequestProperty("Content-Type", "application/json");

		httpCon.setRequestProperty("Accept", "application/json");

		httpCon.setRequestMethod("POST");

		OutputStreamWriter wr= new OutputStreamWriter(httpCon.getOutputStream());		

		wr.flush();

		//display what returns the POST request

		StringBuilder sb = new StringBuilder();  

		int HttpResult =httpCon.getResponseCode(); 
		BufferedReader br=null;
		
		if(HttpResult ==HttpURLConnection.HTTP_OK){

		    br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));  

		    String line = null;  

		    while ((line = br.readLine()) != null) {  
		    	sb.append(line.trim());  
		    }  

		    br.close();  

		}else{
		    System.out.println(httpCon.getResponseMessage());  
		}  
						
        return sb.toString();       
    }
	
	@RequestMapping(value = "/getIpAddres.json", method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String getIpAddres(ServletRequest servletRequest){
		String remoteAddress = servletRequest.getRemoteAddr();
		
		return gson.toJson(remoteAddress); 
	}
}
