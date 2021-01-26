package com.jmdevs.petagram;

import android.media.Image;

public class mascota {

    private String nombre;
    private Integer edad;
    private int pic;
    private String descripcion;
    private Integer rate;

    public mascota(String nom, Integer ed, int img){
        nombre = nom;
        edad = ed;
        pic = img;
        rate = 0;
        descripcion = "---";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public void incRate(){
        rate = rate + 1;
    }

    public void decRate(){
        rate = rate - 1;
    }

}
