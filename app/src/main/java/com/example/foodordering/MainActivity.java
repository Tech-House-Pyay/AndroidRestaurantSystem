package com.example.foodordering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.foodordering.Adapter.RecyclerAdapter;
import com.example.foodordering.Adapter.ViewPagerAdapter;
import com.example.foodordering.models.Menu;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private List<Menu> menuList =new ArrayList<>();
    private RecyclerAdapter adapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setUpAdapter();
        setUpViewPager();
    }

    private void setUpViewPager() {
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpAdapter() {
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        menuList.add(new Menu(R.drawable.food,"Fried Chicken",2000));
        menuList.add(new Menu(R.drawable.drink,"Fried Rice",3000));
        menuList.add(new Menu(R.drawable.food,"Fried Noodle",2000));
        menuList.add(new Menu(R.drawable.drink,"Prawn Spicy",7000));
        adapter=new RecyclerAdapter(MainActivity.this, menuList);

        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView=findViewById(R.id.recyclerView);
        viewPager=findViewById(R.id.viewPager);
        tabLayout=findViewById(R.id.tab);

    }
}
