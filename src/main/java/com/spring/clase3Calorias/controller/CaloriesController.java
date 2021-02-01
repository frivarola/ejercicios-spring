package com.spring.clase3Calorias.controller;

import com.spring.clase3Calorias.responsesDTO.CaloriesByIngredientResponseDTO;
import com.spring.clase3Calorias.responsesDTO.CaloriesTotalResponseDTO;
import com.spring.clase3Calorias.modelDTO.DishDTO;
import com.spring.clase3Calorias.responsesDTO.MaxCaloriesIngredientResponseDTO;
import com.spring.clase3Calorias.service.CalculateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/calories")
public class CaloriesController {

    private CalculateService calculateService;

    public CaloriesController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @PostMapping(path="/getDishCalories")
    public CaloriesTotalResponseDTO calculateDishCalories(@RequestBody DishDTO dishDTO){
        return calculateService.calculateDishCalories(dishDTO);
    }

    @PostMapping(path="/getCaloriesByIngredient")
    public CaloriesByIngredientResponseDTO getCaloriesByIngredient(@RequestBody DishDTO dishDTO){
        return calculateService.getCaloriesByIngredient(dishDTO);
    }

    @PostMapping(path="/getMaxCalories")
    public MaxCaloriesIngredientResponseDTO getMaxCalories(@RequestBody DishDTO dishDTO){
        return calculateService.getMaxCaloriesIngredient(dishDTO);
    }

}
