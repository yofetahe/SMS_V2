package com.fidel.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fidel.sms.model.TeacherInformation;

@Controller
@RequestMapping(value="payment")
public class PaymentController {

	@RequestMapping(value="/getPaymentTemplate", method=RequestMethod.GET)
	public ModelAndView getPaymentTemplate(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("redirect:paymentList");
		
		return modelandview;
	}
	
	@RequestMapping(value="/paymentList", method=RequestMethod.GET)
	public ModelAndView paymentList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("Payment_Fine/payment_template");
		
		return modelandview;
	}
}
