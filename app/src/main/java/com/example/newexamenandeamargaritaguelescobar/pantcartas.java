package com.example.newexamenandeamargaritaguelescobar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.newexamenandeamargaritaguelescobar.Modelos.Envio;
import com.example.newexamenandeamargaritaguelescobar.Modelos.Respuestanumero;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

public class pantcartas extends AppCompatActivity {
    private RequestQueue mQueue;
    Integer numero1 =0, numero2;
    TextView pntlltexto;
    JSONObject jsonBody1 = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantcartas);
        pntlltexto = findViewById(R.id.vistanumerototal);
        findViewById(R.id.btnpedirnumeor).setOnClickListener(this::Perdirnumero);
        findViewById(R.id.resultados).setOnClickListener(this::Cambiarpagina);
        findViewById(R.id.btnenviarnumeor).setOnClickListener(this::Enviarnumero);
        mQueue = SingletonRequest.getInstance(pantcartas.this).getRequestQueue();
    }

    private void Enviarnumero(View view) {
        String ulrApinumero ="https://ramiro.uttics.com/api/enviarnumero";
        JSONObject persona1 = new JSONObject();
        JSONObject jBody = new JSONObject();
        try {
            jBody.put("nombre","Andrea");
            jBody.put("numero",""+numero1);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            JSONObject persona = persona1.put("persona",jBody);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, ulrApinumero, persona1, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Se ah enviado tu numero suertee",Toast.LENGTH_SHORT).show();
            }

        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);

    }


    private void Perdirnumero(View view) {
        String ulrApinumero ="https://ramiro.uttics.com/api/numero";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, ulrApinumero, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = new Gson();

                Respuestanumero respuesta = gson.fromJson(String.valueOf(response), (Type) Respuestanumero.class);
                numero2 = Integer.parseInt(respuesta.getNumero().toString());
                numero1 += numero2;

                pntlltexto.setText(String.valueOf(numero1));
                verificarNume();
            }

        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);

    }

    private void verificarNume() {
        if(numero1>=21){
            Toast.makeText(this,"nmms que wey perdiste carnal",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
    }

    private void Cambiarpagina(View view) {
        Intent intent = new Intent(getApplicationContext(),pantallaresultados.class);
        startActivity(intent);
    }
}