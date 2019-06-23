package com.example.foodordering.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering.Adapter.RecyclerAdapter;
import com.example.foodordering.R;
import com.example.foodordering.models.Data;
import com.example.foodordering.models.Menu;

import java.util.ArrayList;
import java.util.List;


public class FoodFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<Data> dataList =new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        dataList.add(new Data(0,new Menu(R.drawable.food,"Fried Chicken",2000)));
        dataList.add(new Data(0,new Menu(R.drawable.drink,"Fried Rice",2000)));
        dataList.add(new Data(0,new Menu(R.drawable.food,"Fried Noodle",2000)));
        dataList.add(new Data(0,new Menu(R.drawable.drink,"Prawn Spicy",2000)));
        adapter=new RecyclerAdapter(getContext(), dataList);

        recyclerView.setAdapter(adapter);
    }
}
