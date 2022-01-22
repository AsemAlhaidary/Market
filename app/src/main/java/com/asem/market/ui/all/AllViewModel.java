package com.asem.market.ui.all;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.asem.market.R;

public class AllViewModel extends ViewModel {

    private MutableLiveData<String> mPreservesText;
    private MutableLiveData<String> mDrinksText;

    public AllViewModel() {
        mPreservesText = new MutableLiveData<>();
        mDrinksText = new MutableLiveData<>();

        mPreservesText.setValue("Preserves");
        mDrinksText.setValue("Drinks");
    }

    public LiveData<String> getPreservesText() {
        return mPreservesText;
    }

    public LiveData<String> getDrinksText() {
        return mDrinksText;
    }
}