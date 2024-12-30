import { FoodItems } from "src/app/Shared/models/FoodItem";
import { Restaurant } from "src/app/Shared/models/Restaurant";

export interface OrderDTO{

    foodItemsList?: FoodItems[];
    userId?: number;
    restaurant?: Restaurant;
}