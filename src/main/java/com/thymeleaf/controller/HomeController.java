package com.thymeleaf.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	// inject via application.properties
	@Value("${welcome.message}")
	String message;

	private List<String> foods = Arrays.asList("Pizza","Burger","Chats");

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("message", message);
		model.addAttribute("foods", foods);

		return "welcome";
	}

	@GetMapping("/hello")
	public String mainWithParam(@RequestParam(name = "name", required = false, defaultValue = "") String name,
			Model model) {

		model.addAttribute("message", name);
		model.addAttribute("foods", foods);

		return "welcome"; // view
	}
}
