package com.practice.order.mapper;

import com.practice.order.dto.OrderDto;
import com.practice.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANT = Mappers.getMapper(OrderMapper.class);
    Order mapOrderToOrderDto(OrderDto orderDto);
    OrderDto mapOrderDtoToOrder(Order order);
}
