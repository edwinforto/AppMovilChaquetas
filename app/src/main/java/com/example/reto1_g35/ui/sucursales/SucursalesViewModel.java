package com.example.reto1_g35.ui.sucursales;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SucursalesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SucursalesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Seccion Sucursales");
    }

    public LiveData<String> getText() {
        return mText;
    }
}