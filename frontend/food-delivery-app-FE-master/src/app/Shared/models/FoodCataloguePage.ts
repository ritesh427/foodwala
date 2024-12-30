import { FoodItems } from "./FoodItem";
import { Restaurant } from "./Restaurant";

export interface FoodCataloguePage{
    foodItemsList:FoodItems[];
    restaurant:Restaurant;
}