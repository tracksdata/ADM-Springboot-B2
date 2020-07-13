package com.cts.product.controller;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
//@Scope("session")
//@SessionAttributes(names = { "age", "user" })
public class ProductController {

	@RequestMapping("/s1")
	public String test(Model data) {

		System.out.println("===> Hello ...");

		String userName = "Praveen";
		data.addAttribute("age", 10000);
		data.addAttribute("city", "Hyderabad");

		// Model is an interface which set attributes to scope obj

		data.addAttribute("user", userName);

		return "one";
	}

}
