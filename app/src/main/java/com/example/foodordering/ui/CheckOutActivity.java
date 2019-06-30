package com.example.foodordering.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodordering.Adapter.DetailItemAdapter;
import com.example.foodordering.R;
import com.example.foodordering.models.ItemInfo;

import java.util.ArrayList;
import java.util.List;

public class CheckOutActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdaper;
    private RecyclerView.LayoutManager layoutManager;
    List<ItemInfo> itemInfoList=new ArrayList<>();
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        itemInfoList.add(new ItemInfo(R.drawable.europeanfood,"European Food",2500));
        itemInfoList.add(new ItemInfo(R.drawable.salad,"Salad",1500));

        mAdaper =new DetailItemAdapter(getApplicationContext(),itemInfoList);
        recyclerView.setAdapter(mAdaper);
    }
}
