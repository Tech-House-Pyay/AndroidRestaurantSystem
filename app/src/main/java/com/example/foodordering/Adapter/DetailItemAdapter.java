package com.example.foodordering.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering.R;
import com.example.foodordering.models.ItemInfo;

import java.util.List;

public class DetailItemAdapter extends RecyclerView.Adapter<DetailItemAdapter.MyViewHolder> {

    public int totalPrice;
    public Context context;
    public List<ItemInfo> itemInfoList;
    public DetailItemAdapter(Context context,List<ItemInfo> itemInfoList)
    {
        this.context=context;
        this.itemInfoList=itemInfoList;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView imgDetailItem;
        public TextView tvItemName,tvItemPrice,tvQty;
        public ImageButton btnPositive,btnNegative,btnDelete;
        public int count=0;
        public CardView cardView;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imgDetailItem=itemView.findViewById(R.id.imgDetailItem);
            tvItemName=itemView.findViewById(R.id.tvItemName);
            tvItemPrice=itemView.findViewById(R.id.tvItemPrice);

            btnPositive=itemView.findViewById(R.id.btnPositive);
            btnNegative=itemView.findViewById(R.id.btnNegative);
            tvQty=itemView.findViewById(R.id.tvQty);



            cardView=itemView.findViewById(R.id.cardView);


            btnPositive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    count++;
                    tvQty.setText(count+"");
//                    int pos=getAdapterPosition();
//                    ItemInfo info=itemInfoList.get(pos);
//                    int price=info.itemPrice;
//                    totalPrice+=price*count;

                }
            });

            btnNegative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(count>0) {
                        count--;
                        tvQty.setText(count+"");
                    }

                }
            });

            /*btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    cardView.removeAllViews();


                }
            });*/


        }
    }

    @NonNull
    @Override
    public DetailItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detail_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailItemAdapter.MyViewHolder holder, int position) {

        final ItemInfo info=itemInfoList.get(position);
        holder.tvItemName.setText(info.itemName);
        holder.tvItemPrice.setText(info.itemPrice+"");
        holder.imgDetailItem.setImageResource(info.itemImage);
        //Glide.with(context).load(actor.image).into(myViewHolder.imgView);

    }

    @Override
    public int getItemCount() {
        return itemInfoList.size();
    }
}