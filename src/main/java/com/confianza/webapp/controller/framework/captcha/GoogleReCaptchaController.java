package com.confianza.webapp.controller.framework.captcha;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class GoogleReCaptchaController {

	@Autowired
    ReCaptchaImpl reCaptcha;	
	
	@RequestMapping(value = "/validate", method = RequestMethod.POST, produces={"application/json"})
    public String validateCaptcha( HttpServletRequest request,ServletRequest servletRequest, @RequestParam("recaptcha_challenge_field") String challangeField, @RequestParam("recaptcha_response_field") String responseField)
    {
		String remoteAddress = servletRequest.getRemoteAddr();
        ReCaptchaResponse reCaptchaResponse = this.reCaptcha.checkAnswer(remoteAddress, challangeField, responseField);
 
        if(reCaptchaResponse.isValid() ){
            return "valid.captcha";
        } else {
            return "invalid.captcha";           
        }   

    }
}
