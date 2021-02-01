package com.spring.clase3Calorias.responsesDTO;

import com.spring.clase3Calorias.modelDTO.IngredientDTO;

public class MaxCaloriesIngredientResponseDTO {
    private Integer calories;
    private IngredientDTO ingredient;

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public IngredientDTO getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientDTO ingredient) {
        this.ingredient = ingredient;
    }
}
