package com.asem.market;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    ArrayList<MainModel> mainModels;
    Context context;
    int template;

    public MainAdapter(Context context, ArrayList<MainModel> mainModels, int template) {
        this.context = context;
        this.mainModels = mainModels;
        this.template = template;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create View
        View view = LayoutInflater.from(parent.getContext()).inflate(template, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        // Set picture to ImageView
        holder.itemImage.setImageResource(mainModels.get(position).getItemImage());
        // Set name to TextView
        holder.itemName.setText(mainModels.get(position).getItemName());
        // Set price to TextView
        holder.itemPrice.setText(mainModels.get(position).getItemPrice());
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Initialize Variable
        ImageView itemImage;
        TextView itemName;
        TextView itemPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Assign variables
            itemImage = itemView.findViewById(R.id.item_image);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
        }
    }
}
