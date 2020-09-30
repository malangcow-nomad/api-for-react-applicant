package com.test.apiservertest.domain;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
	@Autowired
	private TestService service;
	
	@PostMapping("sign-up")
	public Token signUp() {
		return service.signUp();
	}
	
	@PostMapping("login")
	public Token login(@RequestBody Login login, HttpServletResponse response) {
		return service.login(login, response);
	}
	
	@GetMapping("order")
	public OrderList getOrders(@RequestParam(defaultValue = "0") Long page) {
		return service.getOrders(page);
	}
	
	@GetMapping("order/{id}")
	public OrderItem getOrderItem(@PathVariable Long id) {
		return service.getOrderItem(id);
	}
}
