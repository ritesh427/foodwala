package com.practice.restaurantlisting.Mapper;

import com.practice.restaurantlisting.DTO.RestaurantDto;
import com.practice.restaurantlisting.Entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
    Restaurant mapRestaurantDTOToRestaurant(RestaurantDto restaurantDto);
    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);
}
