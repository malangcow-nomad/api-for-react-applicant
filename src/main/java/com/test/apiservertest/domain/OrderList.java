package com.test.apiservertest.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class OrderList {
	private Long totalPages;
	private Long currentPage;
	private List<OrderItem> content;
}
