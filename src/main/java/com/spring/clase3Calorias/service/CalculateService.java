package com.spring.clase3Calorias.service;

import com.spring.clase3Calorias.responsesDTO.CaloriesTotalResponseDTO;
import com.spring.clase3Calorias.responsesDTO.CaloriesByIngredientResponseDTO;
import com.spring.clase3Calorias.responsesDTO.MaxCaloriesIngredientResponseDTO;
import com.spring.clase3Calorias.modelDTO.DishDTO;

public interface CalculateService {

    CaloriesTotalResponseDTO calculateDishCalories(DishDTO dishDTO);
    CaloriesByIngredientResponseDTO getCaloriesByIngredient(DishDTO dishDTO);
    MaxCaloriesIngredientResponseDTO getMaxCaloriesIngredient(DishDTO dishDTO);

}
