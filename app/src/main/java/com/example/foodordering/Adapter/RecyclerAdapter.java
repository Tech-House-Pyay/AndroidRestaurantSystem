package com.example.foodordering.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodordering.MainActivity;
import com.example.foodordering.R;
import com.example.foodordering.models.Data;
import com.example.foodordering.models.Menu;
import com.example.foodordering.ui.FoodDetailActivity;


import java.util.List;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    //private List<Menu> menuList;
    private List<Data> dataList;
    public RecyclerAdapter(Context context, List<Data> dataList) {
        this.context=context;
        this.dataList = dataList;
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
        final Menu menu=data.menu;
        switch (data.type){
            case 0:
                ((FoodViewHolder)holder).foodName.setText(menu.Food_name);
                ((FoodViewHolder)holder).foodPrice.setText(menu.Food_price+"");
                Glide.with(context).load(menu.Food_image).into(((FoodViewHolder) holder).foodImage);
                break;

            case 1:
                ((PopularFoodViewHolder)holder).foodName.setText(menu.Food_name);
                ((PopularFoodViewHolder)holder).foodPrice.setText(menu.Food_price+"");
                Glide.with(context).load(menu.Food_image).into(((PopularFoodViewHolder) holder).foodImage);
                break;
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, FoodDetailActivity.class);
                intent.putExtra("image",menu.Food_image);
                intent.putExtra("name",menu.Food_name);
                intent.putExtra("price",menu.Food_price);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

     class FoodViewHolder extends RecyclerView.ViewHolder{
        private ImageView foodImage;
        private TextView foodName,foodPrice;

        FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage=itemView.findViewById(R.id.FoodImage);
            foodName=itemView.findViewById(R.id.foodName);
            foodPrice=itemView.findViewById(R.id.foodPrice);
        }
    }

     class PopularFoodViewHolder extends RecyclerView.ViewHolder{
        private ImageView foodImage;
        private TextView foodName,foodPrice;

        PopularFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage=itemView.findViewById(R.id.FoodImage);
            foodName=itemView.findViewById(R.id.foodName);
            foodPrice=itemView.findViewById(R.id.foodPrice);
        }
    }
}
