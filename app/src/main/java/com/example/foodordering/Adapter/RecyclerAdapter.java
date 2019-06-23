package com.example.foodordering.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodordering.R;
import com.example.foodordering.models.Data;
import com.example.foodordering.models.Menu;


import java.util.List;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Menu> menuList;
    private List<Data> dataList;
    public RecyclerAdapter(Context context, List<Menu> menuList) {
        this.context=context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new FoodViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.food_row,parent,false));
            case 1:
                return new PopularFoodViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_food_row,parent,false));
        }

        return null;
    }

    @Override
    public int getItemViewType(int position) {
        switch (dataList.get(position).type) {
            case 0:
                return 0;
            case 1:
                return 1;
        }
        return -1;
    }


    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Data data = dataList.get(position);
        Menu menu=data.menu;
        switch (position){
            case 0:
                ((FoodViewHolder)holder).foodName.setText(menu.Food_name);
                ((FoodViewHolder)holder).foodPrice.setText(menu.Food_price);
                Glide.with(context).load(menu.Food_image).into(((FoodViewHolder) holder).foodImage);
                break;

            case 1:
                ((PopularFoodViewHolder)holder).foodName.setText(menu.Food_name);
                ((PopularFoodViewHolder)holder).foodPrice.setText(menu.Food_price);
                Glide.with(context).load(menu.Food_image).into(((PopularFoodViewHolder) holder).foodImage);
                break;
        }


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder{
        private ImageView foodImage;
        private TextView foodName,foodPrice;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage=itemView.findViewById(R.id.FoodImage);
            foodName=itemView.findViewById(R.id.foodName);
            foodPrice=itemView.findViewById(R.id.foodPrice);
        }
    }

    public static class PopularFoodViewHolder extends RecyclerView.ViewHolder{
        private ImageView foodImage;
        private TextView foodName,foodPrice;

        public PopularFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage=itemView.findViewById(R.id.FoodImage);
            foodName=itemView.findViewById(R.id.foodName);
            foodPrice=itemView.findViewById(R.id.foodPrice);
        }
    }
}