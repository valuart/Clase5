package com.example.clase5;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<Double> result;
    private MutableLiveData<Integer> mostrar;

    public LiveData<Double> getResult() {
        if(result == null){
            result = new MutableLiveData<>();
        }
        return result;
    }

    public LiveData<Integer> getMostrar() {
        if(mostrar == null){
            mostrar = new MutableLiveData<>();
        }
        return mostrar;
    }

    public void hacerCalculo(String nro1, String nro2){
        try {
            double n1 = Double.parseDouble(nro1);
            double n2 = Double.parseDouble(nro2);
            double res = n1 + n2;

            result.setValue(res);
            mostrar.setValue(View.INVISIBLE);
        }catch(NumberFormatException nf){

            mostrar.setValue(View.VISIBLE);
        }
    }
}
