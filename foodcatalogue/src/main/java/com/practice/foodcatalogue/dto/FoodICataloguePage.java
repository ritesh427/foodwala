package com.practice.foodcatalogue.dto;

import com.practice.foodcatalogue.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoodICataloguePage {

    private List<FoodItem> foodItemsList;
    private Restaurant restaurant;
}
