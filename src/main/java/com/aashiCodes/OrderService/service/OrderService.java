package com.aashiCodes.OrderService.service;

import com.aashiCodes.OrderService.dto.OrderRequest;
import com.aashiCodes.OrderService.model.Order;
import com.aashiCodes.OrderService.model.OrderLineItems;
import com.aashiCodes.OrderService.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    private OrderLineItems orderLineItems;
    private final OrderRepository orderRepository;

    public OrderService(OrderLineItems orderLineItems, OrderRepository orderRepository) {
        this.orderLineItems = orderLineItems;
        this.orderRepository = orderRepository;
    }

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderNumber(String.valueOf(orderLineItems));
        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(Object orderLineItemsDto) {
        orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItems.getPrice());
        orderLineItems.setQuantity(orderLineItems.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        return orderLineItems;
    }

}
