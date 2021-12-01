package com.example.reto1_g35.ui.productos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProductosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Sección Productos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}