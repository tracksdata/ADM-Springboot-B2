package com.cts.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	@RequestMapping(value = "/s1")
	public String f1(Model data) {
		data.addAttribute("user", "Praveen");
		return "test";
	}

}
