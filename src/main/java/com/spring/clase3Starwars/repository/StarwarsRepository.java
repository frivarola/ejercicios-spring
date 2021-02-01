package com.spring.clase3Starwars.repository;

import com.spring.clase3Starwars.model.CharacterSW;

import java.util.ArrayList;

public interface StarwarsRepository {

    ArrayList<CharacterSW> getCharactersByLikeName(String likeName);
}
