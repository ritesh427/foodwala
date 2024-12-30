package com.practice.foodcatalogue.service;

import com.practice.foodcatalogue.dto.FoodICataloguePage;
import com.practice.foodcatalogue.dto.FoodItemDto;
import com.practice.foodcatalogue.dto.Restaurant;
import com.practice.foodcatalogue.entity.FoodItem;
import com.practice.foodcatalogue.mapper.FoodItemMapper;
import com.practice.foodcatalogue.repository.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodItemService {
    @Autowired
    FoodItemRepo foodItemRepo;

    @Autowired
    RestTemplate restTemplate;

    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem saved= foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemDto));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(saved);
    }

    public FoodICataloguePage fetchFoodCataloguePageDetails(Integer id) {
        List<FoodItem> foodItems =  fetchFoodItemList(id);
        Restaurant restaurant =  fetchRestaurantDetailsFromRestaurantService (id);
        return createFoodCatalougePage(foodItems,restaurant);
    }

    private List<FoodItem> fetchFoodItemList(Integer id) {
        return foodItemRepo.findByRestaurantId(id);
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantService(Integer id) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchRestaurantById/"+id,Restaurant.class);
    }

    private FoodICataloguePage createFoodCatalougePage(List<FoodItem> foodItems, Restaurant restaurant) {
        FoodICataloguePage foodICataloguePage = new FoodICataloguePage();
        foodICataloguePage.setFoodItemsList(foodItems);
        foodICataloguePage.setRestaurant(restaurant);
        return foodICataloguePage;
    }

}
