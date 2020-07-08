package com.cts.product;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Bean
	public void f1() {
		System.out.println("===> EmployeeService class f1 method");
	}

}
