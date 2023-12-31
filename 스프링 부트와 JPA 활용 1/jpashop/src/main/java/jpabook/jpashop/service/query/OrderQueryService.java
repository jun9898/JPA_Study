package jpabook.jpashop.service.query;

import static java.util.stream.Collectors.*;

import java.util.List;

import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.api.OrderApiController;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderQueryService {

	private final OrderRepository orderRepository;

	public List<OrderDto> orderV3() {
		List<Order> orders = orderRepository.findAllWithItem();
		List<OrderDto> result = orders.stream()
			.map(OrderDto::new)
			.collect(toList());

		return result;
	}

}
