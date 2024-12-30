package com.practice.foodcatalogue.controller;

import com.netflix.discovery.converters.Auto;
import com.practice.foodcatalogue.dto.FoodICataloguePage;
import com.practice.foodcatalogue.dto.FoodItemDto;
import com.practice.foodcatalogue.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
@CrossOrigin
public class FoodItemController {

    @Autowired
    FoodItemService foodItemService;

    @PostMapping("/addfood")
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItemDto){
        FoodItemDto foodItemDtoSaved = foodItemService.addFoodItem(foodItemDto);
        return new ResponseEntity<>(foodItemDtoSaved, HttpStatus.CREATED);

    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{id}")
    public ResponseEntity<FoodICataloguePage> fetchRestaurantDetailsAndFoodMenu(@PathVariable("id") Integer id){
        FoodICataloguePage foodICataloguePage = foodItemService.fetchFoodCataloguePageDetails(id);
        return new ResponseEntity<>(foodICataloguePage,HttpStatus.OK);
    }


}
