package com.practice.restaurantlisting.Service;

import com.practice.restaurantlisting.DTO.RestaurantDto;
import com.practice.restaurantlisting.Entity.Restaurant;
import com.practice.restaurantlisting.Mapper.RestaurantMapper;
import com.practice.restaurantlisting.Repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepo restaurantRepo;

    public ResponseEntity<RestaurantDto> getRestaurantById(int id) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        return restaurant.map(value -> new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    public List<RestaurantDto> findAllRestaurant() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        return restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant)).toList();
    }


    public RestaurantDto addRestaurantInDB(RestaurantDto restaurantDto) {
        Restaurant savedRestaurant = restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDto));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(savedRestaurant);

    }

    public String deleteRestaurantById(int id) {
        Optional<Restaurant> removeById = restaurantRepo.findById(id);
        if (removeById.isPresent()) {
            restaurantRepo.deleteById(id);
            return "Deleted Successfully";
        }
        else {
            return "No Data Found";
        }
    }
}
