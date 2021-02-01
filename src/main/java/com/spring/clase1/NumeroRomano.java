package com.spring.clase1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.websocket.server.PathParam;

@RestController
public class NumeroRomano {

    private static HashMap<Integer, String> diccionario = new HashMap<Integer, String>();
    static{
        diccionario.put(1, "I");
        diccionario.put(2, "II");
        diccionario.put(3, "III");
        diccionario.put(4, "IV");
        diccionario.put(5, "V");
        diccionario.put(6, "VI");
        diccionario.put(7, "VII");
        diccionario.put(8, "VIII");
        diccionario.put(9, "IX");
        diccionario.put(10, "X");
        diccionario.put(50, "L");
        diccionario.put(100, "C");
        diccionario.put(500, "D");
        diccionario.put(1000, "M");
    }

    @GetMapping(path = "/numeroRomano/{decimal}")
   public String calcularRomano(@PathVariable Integer decimal){
        System.out.println(decimal);
        String r = DecimalToRomano(decimal);
        System.out.println("LLego a este resultado " + r);
       return "Numero romano: " + r;
   }

    private void initializeDiccionario(){

        diccionario.put(1, "I");
        diccionario.put(2, "II");
        diccionario.put(3, "III");
        diccionario.put(4, "IV");
        diccionario.put(5, "V");
        diccionario.put(6, "VI");
        diccionario.put(7, "VII");
        diccionario.put(8, "VIII");
        diccionario.put(9, "IX");
        diccionario.put(10, "X");
        diccionario.put(50, "L");
        diccionario.put(100, "C");
        diccionario.put(500, "D");
        diccionario.put(1000, "M");

    }

    private String DecimalToRomano(Integer n){
        System.out.println(n);
        Integer m = n;
        String r = (String) diccionario.get(m);
        System.out.println(r);
        if(r != null){
            return r;
        } else {
            r = "";
            while(m > 0){

                if(m>= 1000){
                    r = r.concat("M");
                    m-= 1000;
                }
                if(m>= 500 && m < 1000){
                    r = r.concat("D");
                    m-= 500;
                }
                if(m>=100 && m < 500){
                    r = r.concat("C");
                    m -= 100;
                }
                if(m >= 50 && m < 100){
                    r = r.concat("L");
                    m -= 50;
                }
                if(m>= 10 && m < 50){
                    r = r.concat("X");
                    m -= 10;
                }
                if(m < 10 && m > 0){
                    r = r.concat((String)diccionario.get(m));
                }
            }

        }
        //aprender
        diccionario.put(n, r);
        return r;
    }
   
}
