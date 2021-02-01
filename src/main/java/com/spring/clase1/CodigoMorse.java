package com.spring.clase1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;


@RestController
public class CodigoMorse {

    private static HashMap<String, String> diccionario = new HashMap<>();
    static{
        diccionario.put(".-", "A");
        diccionario.put("-...", "B");
        diccionario.put("-.-.", "C");
        diccionario.put("----", "CH");
        diccionario.put("-..","D");
        diccionario.put(".", "E");
        diccionario.put( "..-.", "F");
        diccionario.put("--.","G");
        diccionario.put("....", "H");
        diccionario.put("..", "I");
        diccionario.put(".---", "J");
        diccionario.put("-.-", "K");
        diccionario.put(".-..","L");
        diccionario.put("--", "M");
        diccionario.put("-.", "N");
        diccionario.put("--.--", "Ñ");
        diccionario.put("---", "O");
        diccionario.put(".--.", "P");
        diccionario.put("--.-", "Q");
        diccionario.put(".-.", "R");
        diccionario.put("...", "S");
        diccionario.put("-", "T");
        diccionario.put("..-", "U");
        diccionario.put("...-", "V");
        diccionario.put(".--", "W");
        diccionario.put("-..-", "X");
        diccionario.put("-.--", "Y");
        diccionario.put("--..", "Z");
    }
    
    @GetMapping(value="/codigoMorse/{codigo}")
    public String traducirMorse(@PathVariable String codigo){
        String rta = "";
        if(codigo != null){
            rta = interpretarMorse(codigo);
        }
        return rta;
    }

    private String interpretarMorse(String codigo){

        StringBuilder textoTraducido = new StringBuilder();
        String[] palabras = codigo.split("   ");

        for (int i = 0; i < palabras.length; i++) {
            String palabraTraducida = "";
            String[] caracteres = palabras[i].split(" ");
            for (int c = 0; c < caracteres.length; c++) {
                palabraTraducida = palabraTraducida.concat((String) diccionario.get(caracteres[c]));
            }

            textoTraducido.append(" " + palabraTraducida);

        }


        return textoTraducido.toString();
    }


    
}
