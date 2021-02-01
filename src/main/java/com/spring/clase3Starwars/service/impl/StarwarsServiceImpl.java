package com.spring.clase3Starwars.service.impl;

import com.spring.clase3Starwars.model.CharacterSW;
import com.spring.clase3Starwars.repository.impl.StarwarsRepositoryImpl;
import com.spring.clase3Starwars.service.StarwarsService;

import java.util.ArrayList;

public class StarwarsServiceImpl implements StarwarsService {

    private final StarwarsRepositoryImpl repo;

    public StarwarsServiceImpl(StarwarsRepositoryImpl repo) {
        this.repo = repo;
    }

    @Override
    public ArrayList<String> getNameCharactersLike(String name) {
        ArrayList<CharacterSW> characterSWS = repo.getCharactersByLikeName(name);
        ArrayList<String> result = new ArrayList<>();
        for (CharacterSW ch: characterSWS) {
            if(ch.getName().contains(name)){
                result.add(ch.getName());
            }
        }
        return result;
    }
}
