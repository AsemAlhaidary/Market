package com.asem.market.ui.milks;

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

import com.asem.market.MainActivity;
import com.asem.market.MainAdapter;
import com.asem.market.MainModel;
import com.asem.market.MilksProducts;
import com.asem.market.R;
import com.asem.market.databinding.FragmentMilksBinding;

import java.util.ArrayList;

public class MilksFragment extends Fragment {

    private MilksViewModel milksViewModel;
    private FragmentMilksBinding binding;
    private MainActivity MainActivity;
    ArrayList<MainModel> milksMainModels;
    MainAdapter milksMainAdapter;
    MilksProducts milksProducts;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        milksViewModel = new ViewModelProvider(this).get(MilksViewModel.class);

        binding = FragmentMilksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.milksTitle;
        milksViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        initProductsList();

        return root;
    }

    private void initProductsList() {
        milksProducts = new MilksProducts();
        RecyclerView recyclerview = binding.milksRecyclerView;

        Integer[] pictures = milksProducts.pictures;
        String[] productsName = milksProducts.productsNames;
        Float[] productsPrice = milksProducts.productsPrice;

        milksMainModels = new ArrayList<MainModel>();
        for (int i = 0; i < pictures.length; i++) {
            milksMainModels.add(new MainModel(pictures[i], productsName[i], productsPrice[i]));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager((Context) MainActivity, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        // Initialize MainAdapter
        milksMainAdapter = new MainAdapter((Context) MainActivity, milksMainModels, R.layout.list_row_item);

        // Set MainAdapter to RecyclerView
        recyclerview.setAdapter(milksMainAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}