package com.example.foodordering.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodordering.R;

public class FoodDetailActivity extends AppCompatActivity {

    private int image,price;
    private String name;

    private Toolbar toolbar;
    private ImageView FoodImage;
    private TextView foodName,foodPrice,instruction,ingredient;
    private Button btnOrder,btnCheckOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);


        initView();
        Intent intent=getIntent();
        image=intent.getExtras().getInt("image");
        price=intent.getExtras().getInt("price");
        name=intent.getStringExtra("name");
        FoodImage.setImageResource(image);
        foodName.setText(name);
        foodPrice.setText(price+"");
        instruction.setText("he=dfjkdsfj;dfk;ldkjfdkfjk");
        ingredient.setText("ksdfjhdfreojkjrhr;");

    }

    private void initView() {
        toolbar=findViewById(R.id.toolbar);
        FoodImage=findViewById(R.id.detailFood);
        foodName=findViewById(R.id.foodName);
        foodPrice=findViewById(R.id.foodPrice);
        instruction=findViewById(R.id.instruction);
        ingredient=findViewById(R.id.ingretiant);
        btnOrder=findViewById(R.id.order);
        btnCheckOut=findViewById(R.id.CheckOut);
        setSupportActionBar(toolbar);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FoodDetailActivity.this,"Order Now",Toast.LENGTH_SHORT).show();
            }
        });
        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FoodDetailActivity.this,"CheckOut Now",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
