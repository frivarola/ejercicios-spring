package com.spring.clase3Starwars.repository.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.clase3Starwars.model.CharacterSW;
import com.spring.clase3Starwars.repository.StarwarsRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StarwarsRepositoryImpl implements StarwarsRepository {
    private static final ArrayList<CharacterSW> dataBase;
    static{
        dataBase = loadDB();
    }


    @Override
    public ArrayList<CharacterSW> getCharactersByLikeName(String likeName) {
        ArrayList<CharacterSW> charactersSW = (ArrayList<CharacterSW>) dataBase;
        ArrayList<CharacterSW> result = new ArrayList<>();
        for (CharacterSW ch: charactersSW) {
            if(ch.getName().contains(likeName)){
                result.add(ch);
            }
        }

        return result;
    }

    private static ArrayList<CharacterSW> loadDB(){
        ArrayList<CharacterSW> characterSWs = new ArrayList<CharacterSW>();
        File file = null;

        try{
            file = ResourceUtils.getFile("/Users/frivarola/Documents/ProjectsDH/spring/clase1/src/main/java/com/spring/clase3Starwars/starwars.json");
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<ArrayList<CharacterSW>> tf = new TypeReference<>(){};
            characterSWs = mapper.readValue(file, tf);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No se encontro el archivo");
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return characterSWs;
    }
}
