package com.asem.market.ui.foodstuffs;

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
import com.asem.market.FoodstuffsProducts;
import com.asem.market.MainActivity;
import com.asem.market.MainAdapter;
import com.asem.market.MainModel;
import com.asem.market.R;
import com.asem.market.databinding.FragmentChocolatesBinding;
import com.asem.market.databinding.FragmentFoodstuffsBinding;

import java.util.ArrayList;

public class FoodstuffsFragment extends Fragment {

    private FoodstuffsViewModel foodstuffsViewModel;
    private FragmentFoodstuffsBinding binding;
    private MainActivity MainActivity;
    ArrayList<MainModel> foodstuffsMainModels;
    MainAdapter foodstuffsMainAdapter;
    FoodstuffsProducts foodstuffsProducts;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        foodstuffsViewModel = new ViewModelProvider(this).get(FoodstuffsViewModel.class);

        binding = FragmentFoodstuffsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.foodstuffsTitle;
        foodstuffsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        initProductsList();

        return root;
    }

    private void initProductsList() {
        foodstuffsProducts = new FoodstuffsProducts();
        RecyclerView recyclerview = binding.foodstuffsRecyclerView;

        Integer[] pictures = foodstuffsProducts.pictures;
        String[] productsName = foodstuffsProducts.productsNames;
        Float[] productsPrice = foodstuffsProducts.productsPrice;

        foodstuffsMainModels = new ArrayList<MainModel>();
        for (int i = 0; i < pictures.length; i++) {
            foodstuffsMainModels.add(new MainModel(pictures[i], productsName[i], productsPrice[i]));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager((Context) MainActivity, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        // Initialize MainAdapter
        foodstuffsMainAdapter = new MainAdapter((Context) MainActivity, foodstuffsMainModels, R.layout.list_row_item);

        // Set MainAdapter to RecyclerView
        recyclerview.setAdapter(foodstuffsMainAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}