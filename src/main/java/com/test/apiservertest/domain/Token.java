package com.test.apiservertest.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class Token {
	@Builder.Default
	private String token = "12345678";
}
