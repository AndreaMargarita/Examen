package com.example.newexamenandeamargaritaguelescobar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.newexamenandeamargaritaguelescobar.Adaptador.Adaptador;
import com.example.newexamenandeamargaritaguelescobar.Modelos.Respuesta;
import com.example.newexamenandeamargaritaguelescobar.Modelos.itemsresultados;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class pantallaresultados extends AppCompatActivity {

    List<itemsresultados> elemts;
    List<Respuesta> respons;
    Adaptador adapter;
    private RequestQueue mQueue;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantallaresultados);
        respons = new ArrayList<>();
        elemts = new ArrayList<>();
        mQueue = SingletonRequest.getInstance(pantallaresultados.this).getRequestQueue();
        mostrajson();
    }

    private void mostrajson() {
        String ulrApi ="https://ramiro.uttics.com/api/ganadores";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, ulrApi, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                RecyclerView recyclerView = findViewById(R.id.Rc1);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                Gson gson = new Gson();

                Respuesta respuesta = gson.fromJson(response.toString(),Respuesta.class);

                adapter = new Adaptador(respuesta.getResults());

                recyclerView.setAdapter(adapter);

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);

    }
}

