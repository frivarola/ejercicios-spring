package com.spring.clase3Starwars.dtos;

import java.util.ArrayList;

public class ResponseDTO {
    private String msg;
    private Integer count;
    private ArrayList<String> charactersName;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<String> getCharactersName() {
        return charactersName;
    }

    public void setCharactersName(ArrayList<String> charactersName) {
        this.charactersName = charactersName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
