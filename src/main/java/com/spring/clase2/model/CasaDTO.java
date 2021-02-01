package com.spring.clase2.model;

public class CasaDTO {
    private String nombre;
    private String direccion;
    private HabitacionDTO[] habitaciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public HabitacionDTO[] getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(HabitacionDTO[] habitaciones) {
        this.habitaciones = habitaciones;
    }
}
