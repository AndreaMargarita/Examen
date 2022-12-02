package com.example.newexamenandeamargaritaguelescobar.Modelos;

public class Envio {

    private String nombre;
    private Integer numero;
    private int num =0;

    public Envio (String nombre, Integer numero){
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
