package com.spring.clase3Calorias.responsesDTO;

import com.spring.clase3Calorias.modelDTO.IngredientDTO;

import java.util.List;

public class CaloriesByIngredientResponseDTO {

    private List<IngredientDTO> ingredientsWithCalories;

    public List<IngredientDTO> getIngredientsWithCalories() {
        return ingredientsWithCalories;
    }

    public void setIngredientsWithCalories(List<IngredientDTO> ingredientsWithCalories) {
        this.ingredientsWithCalories = ingredientsWithCalories;
    }
}
