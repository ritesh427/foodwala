package com.practice.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer orderId;
    private List<FoodItemDto> foodItemsList;
    private RestaurantDto restaurantDto;
    private UserDto userDto;
}
