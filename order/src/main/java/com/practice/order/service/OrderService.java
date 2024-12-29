package com.practice.order.service;

import com.practice.order.dto.OrderDto;
import com.practice.order.dto.OrderDtoFromFE;
import com.practice.order.dto.UserDto;
import com.practice.order.entity.Order;
import com.practice.order.mapper.OrderMapper;
import com.practice.order.repository.OrderRepository;
import org.apache.catalina.User;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDto saveOrderDetails(OrderDtoFromFE orderDetails) {
        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        UserDto userDto = fetchUserDetailsByUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(newOrderId,orderDetails.getFoodItemsList(),orderDetails.getRestaurant(),userDto);
        orderRepository.save(orderToBeSaved);
        return OrderMapper.INSTANT.mapOrderDtoToOrder(orderToBeSaved);
    }

    private UserDto fetchUserDetailsByUserId(Integer userId) {
       return restTemplate.getForObject("http://USER-SERVICE/user/userbyid/"+userId, UserDto.class);
    }
}
