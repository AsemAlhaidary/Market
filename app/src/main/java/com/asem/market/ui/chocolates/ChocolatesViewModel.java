package com.asem.market.ui.chocolates;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChocolatesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ChocolatesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Chocolates");
    }

    public LiveData<String> getText() {
        return mText;
    }
}