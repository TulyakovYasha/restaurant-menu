package restaurant.util;

import api.dto.MealDTO;
import restaurant.model.MealEntity;


public class MealUtil {

    public static MealDTO convertToDTO(MealEntity mealEntity) {
        return new MealDTO(mealEntity.getUuid(), mealEntity.getName(), mealEntity.getCalories(), mealEntity.getWeight(), mealEntity.getPrice());
    }

    public static MealEntity convertToEntity(MealDTO mealDTO) {
        return new MealEntity(mealDTO.getName(), mealDTO.getCalories(), mealDTO.getWeight(), mealDTO.getPrice());
    }

    public static MealEntity convertToEntityWithUuid(MealDTO mealDTO) {
        return new MealEntity(mealDTO.getUuid(), mealDTO.getName(), mealDTO.getCalories(), mealDTO.getWeight(), mealDTO.getPrice());
    }
}
