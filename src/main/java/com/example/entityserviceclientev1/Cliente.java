package com.example.entityserviceclientev1;

public class Cliente {
    int Id;
    String nombre;
    String correo;

    public Cliente( String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public Cliente( ) {

    }

    public Cliente( int id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "{ \"Id\":\"" + Id + "\", \"nombre\":\"" + nombre + "\", \"correo\":\"" + correo + "\"}";
    }
}
