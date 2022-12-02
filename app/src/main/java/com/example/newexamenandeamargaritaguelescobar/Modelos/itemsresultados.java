package com.example.newexamenandeamargaritaguelescobar.Modelos;

public class itemsresultados {
    private String nombre;
    private String numero;
    private String urlImg;
    private int num =0;

    public itemsresultados (String nombre, String numero){
        this.nombre = nombre;
        this.numero = numero;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        numero = numero;
    }

    public int getNum() {
        num = num +1;
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


}
