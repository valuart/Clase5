package com.example.clase5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText nro1;
    private EditText nro2;
    private EditText resultado;
    private TextView msj;
    private Button calcular;
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVista();
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        vm.getResult().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double result) {
                resultado.setText(result.toString());
            }
        });

        vm.getMostrar().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer visible) {

                    msj.setVisibility(visible);

            }
        });

    }

     private void inicializarVista(){
         nro1 =(EditText)findViewById(R.id.ETNro1);
         nro2 =(EditText)findViewById(R.id.ETNro2);
         resultado = (EditText)findViewById(R.id.ETResultado);
         calcular = (Button)findViewById(R.id.BTCalcular);
         msj = (TextView)findViewById(R.id.TVMensaje);
         calcular.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v) {
                 vm.hacerCalculo(nro1.getText().toString(),nro2.getText().toString());
             }
         });

     }




}