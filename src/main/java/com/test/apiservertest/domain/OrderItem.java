package com.test.apiservertest.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class OrderItem {
	private Long id;
	private String itemName;
}
