package com.test.apiservertest.domain;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	/**
	 * 요청 값에 상관 없이 항상 응답값을 리턴합니다.
	 * @return Token
	 */
	public Token signUp() {
		return Token.builder().build();
	}

	/**
	 * 요청 바디의 password가 8글자 미만 인 경우 401 응답코드를 리턴한다.
	 * 그 외에는 항상 응답값을 리턴한다.
	 * 
	 * @param login
	 * @param response
	 * @return Token
	 */
	public Token login(Login login, HttpServletResponse response) {
		if (login.getPassword().length() >= 8)
			return Token.builder().build();
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		return null;
	}

	/**
	 * page를 입력 받은 후, OrderList를 생성 후 리턴한다.
	 * 의도적으로 1초 Sleep 한다.
	 * page수가 2를 초과하는 경우 빈 배열로 리턴한다.
	 * 
	 * @param page
	 * @return OrderList
	 */
	public OrderList getOrders(Long page) {
		if (page > 2) return OrderList.builder().totalPages(3l).currentPage(page).content(new ArrayList<OrderItem>()).build();
		
		try {
			Thread.sleep(1000l);
		} catch (InterruptedException e) {
			
		}
		List<OrderItem> items = new ArrayList<OrderItem>();
		for (int i = 1; i <= 10; i++) {
			OrderItem item = OrderItem.builder().id(i + page * 10).itemName("아이템".concat(Long.toString(i + page * 10)))
					.build();
			items.add(item);
		}
		return OrderList.builder().totalPages(3l).currentPage(page).content(items).build();
	}

	/**
	 * 입력 받은 id로 아이템 생성 후 응답한다.
	 * @param id
	 * @return
	 */
	public OrderItem getOrderItem(Long id) {
		OrderItem item = OrderItem.builder().id(id).itemName("아이템".concat(Long.toString(id))).build();
		return item;
	}

}
