package com.spring.clase2;

import com.spring.clase2.model.CalculadorM2ResponseDTO;
import com.spring.clase2.model.CasaDTO;
import com.spring.clase2.model.HabitacionDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CalculadorM2 {

    @PostMapping(value = "/calculadorM2/")
    public CalculadorM2ResponseDTO calcularM2(@RequestBody CasaDTO casa) {

        return null;
    }

    private double calcularM2(HabitacionDTO[] habitaciones){
        double totalM2 = 0;
        for(HabitacionDTO h : habitaciones){
            totalM2 += h.getAncho() * h.getLargo();
        }

        return totalM2;
    }

    private double cotizarCasa(CasaDTO c){
        return calcularM2(c.getHabitaciones()) * 800;
    }


}
