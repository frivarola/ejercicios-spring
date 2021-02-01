package com.spring.clase2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;
import java.util.GregorianCalendar;


@RestController
public class CalculadorEdad {

    @GetMapping(value = "/calcularEdad/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){

        int edad = this.calculadorEdad(dia, mes, anio);
        return "Tu edad es : " + edad;
    }

    @GetMapping(value = "/calcularEdad/{mes}/{anio}")
    public String calcularEdad(@PathVariable Integer mes, @PathVariable Integer anio){
        int edad = this.calculadorEdad(mes, anio);
        return "Tu edad es : " + edad;
    }

    @GetMapping(value = "/calcularEdad/{anio}")
    public String calcularEdad(@PathVariable Integer anio){
        int edad = this.calculadorEdad(anio);
        return "Tu edad es : " + edad;
    }

    private int calculadorEdad(int dia, int mes, int anio){
        Calendar c = new GregorianCalendar(anio, mes, dia);
        Calendar hoy = new GregorianCalendar();
        int yearDiff = hoy.get(Calendar.YEAR) - c.get(Calendar.YEAR);
        int monthDiff = hoy.get(Calendar.MONTH) + 1 - c.get(Calendar.MONTH);

        if(monthDiff == 0){
            //estoy en el mes, revisar dia
            int dayDiff = hoy.get(Calendar.DAY_OF_MONTH) - c.get(Calendar.DAY_OF_MONTH);
            if(dayDiff < 0){
                yearDiff--;
            }
        }
        if(monthDiff < 0){
            yearDiff--;
        }

        return yearDiff;
    }

    private int calculadorEdad(int mes, int anio){
        Calendar c = new GregorianCalendar(anio, mes, 1);
        Calendar hoy = new GregorianCalendar();
        int yearDiff = hoy.get(Calendar.YEAR) - c.get(Calendar.YEAR);
        int monthDiff = hoy.get(Calendar.MONTH) + 1 - c.get(Calendar.MONTH);

        if(monthDiff <= 0){
            yearDiff--;
        }

        return yearDiff;
    }

    private int calculadorEdad(int anio){
        Calendar c = new GregorianCalendar(anio, 1, 1);
        Calendar hoy = new GregorianCalendar();
        int yearDiff = hoy.get(Calendar.YEAR) - c.get(Calendar.YEAR);

        return yearDiff;
    }
    
}
