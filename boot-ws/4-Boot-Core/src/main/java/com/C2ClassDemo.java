package com;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class C2ClassDemo {

	@Bean
	public void f5() {
		System.out.println("===> C2ClassDemo of f4 method");
	}
}
