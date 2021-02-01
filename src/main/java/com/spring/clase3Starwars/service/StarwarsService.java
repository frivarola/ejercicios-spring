package com.spring.clase3Starwars.service;

import com.spring.clase3Starwars.dtos.RequestDTO;
import com.spring.clase3Starwars.dtos.ResponseDTO;

public interface StarwarsService {

    ResponseDTO getNameCharactersLike(RequestDTO request);
}
