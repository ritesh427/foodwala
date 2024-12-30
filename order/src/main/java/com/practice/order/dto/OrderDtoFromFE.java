package com.practice.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDtoFromFE {

    private List<FoodItemDto> foodItemsList;
    private Integer userId;
    private RestaurantDto restaurant;

}
