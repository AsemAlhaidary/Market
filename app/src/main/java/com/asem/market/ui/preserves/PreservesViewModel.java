package com.asem.market.ui.preserves;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PreservesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PreservesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Preserves");
    }

    public LiveData<String> getText() {
        return mText;
    }
}