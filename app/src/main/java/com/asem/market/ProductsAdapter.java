package com.asem.market;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.asem.market.databinding.ProductsListBinding;
import com.asem.market.databinding.RowItemBinding;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class ProductsAdapter extends ArrayAdapter<MainModel> {

    private RowItemBinding rowItemBinding;

    public ProductsAdapter(Context context, ArrayList<MainModel> productsArray) {
        super(context, 0, productsArray);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_row_item, parent, false);
        }

        MainModel currentItemModel = getItem(position);

        ShapeableImageView itemImage = rowItemBinding.itemImage;
        itemImage.setImageResource(currentItemModel.getItemImage());

        TextView itemName = rowItemBinding.itemName;
        itemName.setText(currentItemModel.getItemName());

        TextView itemPrice = rowItemBinding.itemPrice;
        itemPrice.setText(currentItemModel.getItemPrice());

        return listItemView;
    }
}
