package com.spring.clase3Starwars.service.impl;

import com.spring.clase3Starwars.dtos.RequestDTO;
import com.spring.clase3Starwars.dtos.ResponseDTO;
import com.spring.clase3Starwars.model.CharacterSW;
import com.spring.clase3Starwars.repository.impl.StarwarsRepositoryImpl;
import com.spring.clase3Starwars.service.StarwarsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StarwarsServiceImpl implements StarwarsService {

    private final StarwarsRepositoryImpl repo;

    public StarwarsServiceImpl(StarwarsRepositoryImpl repo) {
        this.repo = repo;
    }

    @Override
    public ResponseDTO getNameCharactersLike(RequestDTO request) {
        String name = request.getLikeName();
        ArrayList<CharacterSW> characterSWS = repo.getCharactersByLikeName(name);
        ArrayList<String> result = new ArrayList<>();

        for (CharacterSW ch: characterSWS) {
            if(ch.getName().contains(name)){
                result.add(ch.getName());
            }
        }

        ResponseDTO response = new ResponseDTO();
        response.setCharactersName(result);
        response.setMsg("Ok");
        response.setCount(result.size());

        return response;
    }
}
