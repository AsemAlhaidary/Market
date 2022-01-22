package com.asem.market.ui.preserves;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asem.market.MainActivity;
import com.asem.market.MainAdapter;
import com.asem.market.MainModel;
import com.asem.market.PreservesProducts;
import com.asem.market.R;
import com.asem.market.databinding.FragmentPreservesBinding;

import java.util.ArrayList;

public class PreservesFragment extends Fragment {

    private PreservesViewModel preservesViewModel;
    private FragmentPreservesBinding binding;
    private MainActivity MainActivity;
    ArrayList<MainModel> preservesMainModels;
    MainAdapter preservesMainAdapter;
    PreservesProducts preservesProducts;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        preservesViewModel = new ViewModelProvider(this).get(PreservesViewModel.class);

        binding = FragmentPreservesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.preservesTitle;
        preservesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        initProductsList();

        return root;
    }

    private void initProductsList() {
        preservesProducts = new PreservesProducts();
        RecyclerView recyclerview = binding.preservesRecyclerView;

        Integer[] pictures = preservesProducts.pictures;
        String[] productsName = preservesProducts.productsNames;
        Float[] productsPrice = preservesProducts.productsPrice;

        preservesMainModels = new ArrayList<MainModel>();
        for (int i = 0; i < pictures.length; i++) {
            preservesMainModels.add(new MainModel(pictures[i], productsName[i], productsPrice[i]));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager((Context) MainActivity, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        // Initialize MainAdapter
        preservesMainAdapter = new MainAdapter((Context) MainActivity, preservesMainModels, R.layout.list_row_item);

        // Set MainAdapter to RecyclerView
        recyclerview.setAdapter(preservesMainAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}