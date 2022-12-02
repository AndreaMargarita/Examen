package com.example.newexamenandeamargaritaguelescobar.Modelos;

import java.util.List;

public class Respuesta {
    private String status;
    private List<itemsresultados> data;

    public Respuesta(String status,List<itemsresultados> data){
        this.status=status;
        this.data= data;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public List<itemsresultados> getResults() {
        return data;
    }

    public void setResults(List<itemsresultados> data) {
        this.data = data;
    }
}
