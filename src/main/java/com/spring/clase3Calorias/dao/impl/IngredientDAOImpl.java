package com.spring.clase3Calorias.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.clase3Calorias.dao.IngredientDAO;
import com.spring.clase3Calorias.modelDTO.IngredientDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientDAOImpl implements IngredientDAO {

    private static List<IngredientDTO> dataBase;
    static{
        dataBase = loadDataBase();
    }

    @Override
    public Integer getCaloriesByName(String name) {
        List<IngredientDTO> ingredientDTOS = dataBase;

        for (IngredientDTO i: ingredientDTOS) {
            if(i.getName().equals(name)){
                return i.getCalories();
            }
        }
        //Si no encuentra, devuelve -1
        return -1;
    }

    private static List<IngredientDTO> loadDataBase(){
        File file = null;
        List<IngredientDTO> ingredients = new ArrayList<IngredientDTO>();

        try{
            file = ResourceUtils.getFile("/Users/frivarola/Documents/ProjectsDH/spring/clase1/src/main/java/com/spring/clase3Calorias/food.json");

            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<IngredientDTO>> typeRef = new TypeReference<>(){};

            ingredients = mapper.readValue(file, typeRef);

        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("No encontro el archivo");
        }catch (IOException io){
            io.printStackTrace();
            System.out.println("Ocurrio un error al leer el json");
        }

        return ingredients;
    }
}
