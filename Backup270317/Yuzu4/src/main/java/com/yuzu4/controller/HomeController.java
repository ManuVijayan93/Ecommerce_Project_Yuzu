package com.yuzu4.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yuzu.dao.UserDAO;
import com.yuzu.domain.User;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	HttpSession session;

	@Autowired
	User user;

	@Autowired
	UserDAO userDAO;

	@RequestMapping("/")
	public ModelAndView showHomePage() {
		System.out.println("check");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("msg", "Welcome to Yuzu");
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		System.out.println("check5");
		ModelAndView mv = new ModelAndView("/Home");

		session.removeAttribute("loginMessage");

		return mv;
	}

	@RequestMapping("/home")
	public String home() {

		return "home";
	}

	@RequestMapping("/aboutUs")
	public String aboutUs() {

		return "aboutUs";
	}

}
