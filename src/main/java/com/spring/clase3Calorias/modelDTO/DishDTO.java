package com.spring.clase3Calorias.modelDTO;

import java.util.ArrayList;

public class DishDTO {
    private String name;
    private ArrayList<IngredientDTO> ingredients;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }
}
