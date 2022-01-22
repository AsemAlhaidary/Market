package com.asem.market.ui.drinks;

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
import com.asem.market.R;
import com.asem.market.databinding.FragmentDrinksBinding;

import java.util.ArrayList;

public class DrinksFragment extends Fragment {

    private DrinksViewModel drinksViewModel;
    private FragmentDrinksBinding binding;
    private MainActivity MainActivity;
    ArrayList<MainModel> drinksMainModels;
    MainAdapter drinksMainAdapter;
    DrinksProducts drinksProducts;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        drinksViewModel = new ViewModelProvider(this).get(DrinksViewModel.class);

        binding = FragmentDrinksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.drinksTitle;
        drinksViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        initProductsList();

        return root;
    }

    private void initProductsList() {
        drinksProducts = new DrinksProducts();
        RecyclerView recyclerview = binding.drinksRecyclerView;

        Integer[] pictures = drinksProducts.pictures;
        String[] productsName = drinksProducts.productsNames;
        Float[] productsPrice = drinksProducts.productsPrice;

        drinksMainModels = new ArrayList<MainModel>();
        for (int i = 0; i < pictures.length; i++) {
            drinksMainModels.add(new MainModel(pictures[i], productsName[i], productsPrice[i]));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager((Context) MainActivity, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        // Initialize MainAdapter
        drinksMainAdapter = new MainAdapter((Context) MainActivity, drinksMainModels, R.layout.list_row_item);

        // Set MainAdapter to RecyclerView
        recyclerview.setAdapter(drinksMainAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}