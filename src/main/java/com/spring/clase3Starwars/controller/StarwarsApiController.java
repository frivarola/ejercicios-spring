package com.spring.clase3Starwars.controller;

import com.spring.clase3Starwars.dtos.RequestDTO;
import com.spring.clase3Starwars.dtos.ResponseDTO;
import com.spring.clase3Starwars.service.StarwarsService;
import com.spring.clase3Starwars.service.impl.StarwarsServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/star-wars")
public class StarwarsApiController {
    private StarwarsServiceImpl starwarsService;

    public StarwarsApiController(StarwarsServiceImpl starwarsService) {
        this.starwarsService = starwarsService;
    }

    @PostMapping(path="/getNameCharactersLike")
    public ResponseDTO getNameCharactersLike(@RequestBody RequestDTO request){
        return this.starwarsService.getNameCharactersLike(request);
    }
}
