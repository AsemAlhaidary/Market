package com.asem.market.ui.chocolates;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asem.market.ChocolatesProducts;
import com.asem.market.MainActivity;
import com.asem.market.MainAdapter;
import com.asem.market.MainModel;
import com.asem.market.R;
import com.asem.market.databinding.FragmentChocolatesBinding;

import java.util.ArrayList;

public class ChocolatesFragment extends Fragment {

    private ChocolatesViewModel chocolatesViewModel;
    private FragmentChocolatesBinding binding;
    private MainActivity MainActivity;
    ArrayList<MainModel> chocolatesMainModels;
    MainAdapter chocolatesMainAdapter;
    ChocolatesProducts chocolatesProducts;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        chocolatesViewModel = new ViewModelProvider(this).get(ChocolatesViewModel.class);

        binding = FragmentChocolatesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.chocolatesTitle;
        chocolatesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        initProductsList();

        return root;
    }

    private void initProductsList() {
        chocolatesProducts = new ChocolatesProducts();
        RecyclerView recyclerview = binding.chocolatesRecyclerView;

        Integer[] pictures = chocolatesProducts.pictures;
        String[] productsName = chocolatesProducts.productsNames;
        Float[] productsPrice = chocolatesProducts.productsPrice;

        chocolatesMainModels = new ArrayList<MainModel>();
        for (int i = 0; i < pictures.length; i++) {
            chocolatesMainModels.add(new MainModel(pictures[i], productsName[i], productsPrice[i]));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager((Context) MainActivity, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        // Initialize MainAdapter
        chocolatesMainAdapter = new MainAdapter((Context) MainActivity, chocolatesMainModels, R.layout.list_row_item);

        // Set MainAdapter to RecyclerView
        recyclerview.setAdapter(chocolatesMainAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}