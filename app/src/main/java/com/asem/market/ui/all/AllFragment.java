package com.asem.market.ui.all;

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

import com.asem.market.DrinksProducts;
import com.asem.market.MainActivity;
import com.asem.market.MainAdapter;
import com.asem.market.MainModel;
import com.asem.market.PreservesProducts;
import com.asem.market.R;
import com.asem.market.databinding.FragmentAllBinding;

import java.util.ArrayList;

public class AllFragment extends Fragment {

    private AllViewModel allViewModel;
    private FragmentAllBinding binding;
    private MainActivity MainActivity;
    ArrayList<MainModel> preservesMainModels, drinksMainModels;
    MainAdapter preservesMainAdapter, drinksMainAdapter;
    PreservesProducts preservesProducts;
    DrinksProducts drinksProducts;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        allViewModel = new ViewModelProvider(this).get(AllViewModel.class);

        binding = FragmentAllBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView preservesTitle = binding.preservesTitle;
        allViewModel.getPreservesText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                preservesTitle.setText(s);
            }
        });

        final TextView drinksTitle = binding.drinksTitle;
        allViewModel.getDrinksText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                drinksTitle.setText(s);
            }
        });

        initProductsList();

        return root;
    }

    private void initProductsList() {
        preservesProducts = new PreservesProducts();
        drinksProducts = new DrinksProducts();

        RecyclerView recyclerViewPreserves = binding.recyclerViewPreserves;
        RecyclerView recyclerViewDrinks = binding.recyclerViewDrinks;

        Integer[] preservesPictures = preservesProducts.pictures;
        String[] preservesProductsName = preservesProducts.productsNames;
        Float[] preservesProductsPrice = preservesProducts.productsPrice;
        Integer[] drinksPictures = drinksProducts.pictures;
        String[] drinksProductsName = drinksProducts.productsNames;
        Float[] drinksProductsPrice = drinksProducts.productsPrice;

        preservesMainModels = new ArrayList<MainModel>();
        for (int i = 0; i < preservesPictures.length; i++) {
            preservesMainModels.add(new MainModel(preservesPictures[i], preservesProductsName[i], preservesProductsPrice[i]));
        }

        drinksMainModels = new ArrayList<MainModel>();
        for (int i = 0; i < drinksPictures.length; i++) {
            drinksMainModels.add(new MainModel(drinksPictures[i], drinksProductsName[i], drinksProductsPrice[i]));
        }

        LinearLayoutManager preservesLayoutManager = new LinearLayoutManager((Context) MainActivity, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager drinksLayoutManager = new LinearLayoutManager((Context) MainActivity, LinearLayoutManager.HORIZONTAL, false);

        recyclerViewPreserves.setLayoutManager(preservesLayoutManager);
        recyclerViewPreserves.setItemAnimator(new DefaultItemAnimator());
        recyclerViewDrinks.setLayoutManager(drinksLayoutManager);
        recyclerViewDrinks.setItemAnimator(new DefaultItemAnimator());

        // Initialize MainAdapter
        preservesMainAdapter = new MainAdapter((Context) MainActivity, preservesMainModels, R.layout.row_item);
        drinksMainAdapter = new MainAdapter((Context) MainActivity, drinksMainModels, R.layout.row_item);

        // Set MainAdapter to RecyclerView
        recyclerViewPreserves.setAdapter(preservesMainAdapter);
        recyclerViewDrinks.setAdapter(drinksMainAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}