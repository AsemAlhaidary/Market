package com.asem.market.ui.drinks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DrinksViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DrinksViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Drinks");
    }

    public LiveData<String> getText() {
        return mText;
    }
}