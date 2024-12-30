package com.practice.order.controller;

import com.practice.order.dto.OrderDto;
import com.practice.order.dto.OrderDtoFromFE;
import com.practice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("saveOrder")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFromFE orderDetails){
        OrderDto saveOrderDetails  = orderService.saveOrderDetails(orderDetails);
        return new ResponseEntity<>(saveOrderDetails, HttpStatus.CREATED);
    }
}
