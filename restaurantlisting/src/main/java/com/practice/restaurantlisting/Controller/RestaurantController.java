package com.practice.restaurantlisting.Controller;

import com.practice.restaurantlisting.DTO.RestaurantDto;
import com.practice.restaurantlisting.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurant")
    public ResponseEntity<List<RestaurantDto>> fetchAllRestaurant(){
        List<RestaurantDto> restaurantList = restaurantService.findAllRestaurant();
        return new ResponseEntity<>(restaurantList, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> saveRestaurant(@RequestBody RestaurantDto restaurantDto){
        RestaurantDto restaurantAdded = restaurantService.addRestaurantInDB(restaurantDto);
        return new ResponseEntity<>(restaurantAdded,HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantById/{id}")
    public ResponseEntity<RestaurantDto> fetchById(@PathVariable("id") int id){
        return restaurantService.getRestaurantById(id);
    }

    @DeleteMapping("/deteleRestaurantById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id){
        String s = restaurantService.deleteRestaurantById(id);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }
}
