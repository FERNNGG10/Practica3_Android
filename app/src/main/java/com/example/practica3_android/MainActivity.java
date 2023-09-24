package com.example.practica3_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    double num1=0;
    double resp=0;
    String operacion="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cero = findViewById(R.id.cero);
        Button uno = findViewById(R.id.uno);
        Button dos = findViewById(R.id.dos);
        Button tres = findViewById(R.id.tres);
        Button cuatro = findViewById(R.id.cuatro);
        Button cinco = findViewById(R.id.cinco);
        Button seis = findViewById(R.id.seis);
        Button siete = findViewById(R.id.siete);
        Button ocho = findViewById(R.id.ocho);
        Button nueve = findViewById(R.id.nueve);

        Button borrar = findViewById(R.id.borrar);
        Button ac = findViewById(R.id.AC);
        Button porcentaje = findViewById(R.id.porcent);
        Button dividir = findViewById(R.id.div);
        Button multiplicar = findViewById(R.id.multiplicacion);
        Button respuesta = findViewById(R.id.igual);
        Button punto = findViewById(R.id.punto);
        Button resta = findViewById(R.id.menos);
        Button suma = findViewById(R.id.suma);

        TextView resultado = findViewById(R.id.result);

        ArrayList<Button> numeros = new ArrayList<>();
        numeros.add(cero);
        numeros.add(uno);
        numeros.add(dos);
        numeros.add(tres);
        numeros.add(cuatro);
        numeros.add(cinco);
        numeros.add(seis);
        numeros.add(siete);
        numeros.add(ocho);
        numeros.add(nueve);

        for (Button b : numeros)
        {
           b.setOnClickListener(view ->{
               if(!resultado.getText().toString().equals("0"))
               {
                   resultado.setText(resultado.getText().toString()+b.getText().toString());
               }
               else {
                   resultado.setText(b.getText().toString());
               }
           });
        }

        ArrayList<Button> operadores = new ArrayList<>();
        operadores.add(suma);
        operadores.add(resta);
        operadores.add(porcentaje);
        operadores.add(multiplicar);
        operadores.add(dividir);
        operadores.add(respuesta);

        for (Button b:operadores)
        {
            b.setOnClickListener(view->{
                num1 = Double.parseDouble(resultado.getText().toString());
                operacion=b.getText().toString();
                resultado.setText("0");
            });
        }


        borrar.setOnClickListener(view->{
            String num = resultado.getText().toString();
            if(num.length()>1)
            {
                resultado.setText(num.substring(0,num.length()-1));
            } else if (num.length()==1 && num.equals("0")) {
                resultado.setText("0");
            }
        });

        punto.setOnClickListener(view-> {
            if(!resultado.getText().toString().contains(".")){
                resultado.setText(resultado.getText().toString() + ".");
            }
        });

        porcentaje.setOnClickListener(view->{
            num1= Double.parseDouble(resultado.getText().toString());
            resp=num1/100;
            resultado.setText(String.valueOf(resp));
        });

        respuesta.setOnClickListener(view-> {
            Double num2 = Double.parseDouble(resultado.getText().toString());
            double resp;

            switch (operacion)
            {
                case "/":
                    resp = num1/num2;
                    break;
                case "x":
                    resp = num1*num2;
                    break;
                case "-":
                    resp = num1-num2;
                    break;
                case "+":
                    resp = num1+num2;
                    break;

                default:
                    resp=num1+num2;
            }
            resultado.setText(String.valueOf(resp));
            num1=resp;
        });

        ac.setOnClickListener(view-> {
            num1=0;
            resultado.setText("0");
        });

    }

}