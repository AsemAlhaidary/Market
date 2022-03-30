package com.asem.market.ui.milks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MilksViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MilksViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Milks");
    }

    public LiveData<String> getText() {
        return mText;
    }
}