package com.practice.order.entity;

import com.practice.order.dto.FoodItemDto;
import com.practice.order.dto.RestaurantDto;
import com.practice.order.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private Integer orderId;
    private List<FoodItemDto> foodItemsList;
    private RestaurantDto restaurantDto;
    private UserDto userDto;
}
