package com.asem.market.ui.foodstuffs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FoodstuffsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FoodstuffsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Food Stuffs");
    }

    public LiveData<String> getText() {
        return mText;
    }
}