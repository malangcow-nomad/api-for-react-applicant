package com.test.apiservertest.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class Login {
	private String email;
	
	private String password;
}
