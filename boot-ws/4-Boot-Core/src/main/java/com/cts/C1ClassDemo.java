package com.cts;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class C1ClassDemo {

	@Bean
	public void f4() {
		System.out.println("===> C1ClassDemo of f4 method");
	}

}
