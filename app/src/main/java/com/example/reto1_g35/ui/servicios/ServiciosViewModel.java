package com.example.reto1_g35.ui.servicios;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ServiciosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ServiciosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Sección Servicios");
    }

    public LiveData<String> getText() {
        return mText;
    }
}