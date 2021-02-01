package com.spring.clase3Calorias.service;

import com.spring.clase3Calorias.responsesDTO.CaloriesTotalResponseDTO;
import com.spring.clase3Calorias.dao.impl.IngredientDAOImpl;
import com.spring.clase3Calorias.responsesDTO.CaloriesByIngredientResponseDTO;
import com.spring.clase3Calorias.responsesDTO.MaxCaloriesIngredientResponseDTO;
import com.spring.clase3Calorias.modelDTO.DishDTO;
import com.spring.clase3Calorias.modelDTO.IngredientDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculateServiceImpl implements CalculateService{

    private final IngredientDAOImpl ingredientDAOImpl;

    public CalculateServiceImpl(IngredientDAOImpl ingredientDAOImpl) {
        this.ingredientDAOImpl = ingredientDAOImpl;
    }

    @Override
    public CaloriesTotalResponseDTO calculateDishCalories(DishDTO dishDTO) {
        ArrayList<IngredientDTO> ingredientsDish = dishDTO.getIngredients();
        Integer totalCalories = 0;

        for (IngredientDTO i: ingredientsDish) {
            totalCalories += ingredientDAOImpl.getCaloriesByName(i.getName());
        }

        CaloriesTotalResponseDTO response = new CaloriesTotalResponseDTO();
        response.setTotalCalories(totalCalories);
        return response;
    }

    @Override
    public CaloriesByIngredientResponseDTO getCaloriesByIngredient(DishDTO dishDTO) {
        ArrayList<IngredientDTO> ingredientsDish = dishDTO.getIngredients();
        List<IngredientDTO> calories = new ArrayList<IngredientDTO>();

        for (IngredientDTO i: ingredientsDish) {
            i.setCalories(ingredientDAOImpl.getCaloriesByName(i.getName()));
            calories.add(i);
        }

        CaloriesByIngredientResponseDTO response = new CaloriesByIngredientResponseDTO();
        response.setIngredientsWithCalories(calories);

        return response;
    }

    @Override
    public MaxCaloriesIngredientResponseDTO getMaxCaloriesIngredient(DishDTO dishDTO) {
        ArrayList<IngredientDTO> ingredientsDish = dishDTO.getIngredients();
        IngredientDTO maxCal = new IngredientDTO();
        maxCal.setCalories(0);

        for (IngredientDTO i: ingredientsDish) {
            Integer iCalories = ingredientDAOImpl.getCaloriesByName(i.getName());
            if(maxCal.getCalories() < iCalories){
                maxCal = i;
                maxCal.setCalories(iCalories);
            }

        }

        MaxCaloriesIngredientResponseDTO response = new MaxCaloriesIngredientResponseDTO();
        response.setIngredient(maxCal);
        response.setCalories(maxCal.getCalories());

        return response;
    }
}
