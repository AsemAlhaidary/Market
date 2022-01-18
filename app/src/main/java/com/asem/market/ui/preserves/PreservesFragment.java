package com.asem.market.ui.preserves;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
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
import com.asem.market.ProductsAdapter;
import com.asem.market.R;
import com.asem.market.databinding.FragmentPreservesBinding;
import com.asem.market.databinding.ProductsListBinding;

import java.util.ArrayList;

public class PreservesFragment extends Fragment {

    private PreservesViewModel preservesViewModel;
    private ProductsListBinding binding;
//    private FragmentPreservesBinding binding;

    // Initialize variables
//    RecyclerView recyclerview;
    ListView listView;
    ArrayList<MainModel> preservesMainModels;
//    MainAdapter preservesMainAdapter;
    ProductsAdapter preservesProductsAdapter;
    private MainActivity MainActivity;
//    private MainActivity MainActivity;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        preservesViewModel = new ViewModelProvider(this).get(PreservesViewModel.class);

        binding = ProductsListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.categoryName;
        preservesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        // Assign Variables
        listView = binding.listView;

        // Create Images Array
        Integer[] pictures = {R.drawable.one, R.drawable.two, R.drawable.three,
                R.drawable.four, R.drawable.five, R.drawable.six};

        // Create Names Array
        String[] picturesNames = {"One", "Two", "Three", "Four", "Five", "Six"};

        // Create Prices Array
        Float[] productsPrice = {32.0f, 32.0f, 44.0f, 21.0f, 65.0f, 43.0f};

        // Initialize ArrayList
        preservesMainModels = new ArrayList<MainModel>();
        for (int i = 0; i < pictures.length; i++) {
            preservesMainModels.add(new MainModel(pictures[i], picturesNames[i], productsPrice[i]));
        }

        // Design Horizontal Layout
//        LinearLayoutManager layoutManager = new LinearLayoutManager((Context) MainActivity, LinearLayoutManager.HORIZONTAL, false);
//        recyclerview.setLayoutManager(layoutManager);
//        recyclerview.setItemAnimator(new DefaultItemAnimator());

        // Initialize MainAdapter
        preservesProductsAdapter = new ProductsAdapter(getContext(), preservesMainModels);

        // Set MainAdapter to RecyclerView
        listView.setAdapter(preservesProductsAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}