package com.example.foodordering.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.foodordering.Adapter.CategoryAdapter;
import com.example.foodordering.Adapter.FastDeliveryAdapter;
import com.example.foodordering.Domain.CategoryDomain;
import com.example.foodordering.Domain.FastDeliveryDomain;
import com.example.foodordering.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter1, adapter2;
    private RecyclerView recyclerViewCategory, recyclerViewFastList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        recyclerViewCategory();
        recyclerViewFastList();

    }

    private void recyclerViewFastList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFastList = findViewById(R.id.view2);
        recyclerViewFastList.setLayoutManager(linearLayoutManager);

        ArrayList<FastDeliveryDomain> fastDeliveryDomains = new ArrayList<>();
        fastDeliveryDomains.add(new FastDeliveryDomain("Cheese burger", "fast_1", 9.0, 20));
        fastDeliveryDomains.add(new FastDeliveryDomain("Pepperoni pizza", "fast_2", 8.1, 16));
        fastDeliveryDomains.add(new FastDeliveryDomain("Vegetable pizza", "fast_3", 9.5, 18));

        adapter2 = new FastDeliveryAdapter(fastDeliveryDomains);
        recyclerViewFastList.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategory = findViewById(R.id.view1);
        recyclerViewCategory.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza", "cat_1"));
        categoryList.add(new CategoryDomain("Burger", "cat_2"));
        categoryList.add(new CategoryDomain("Chicken", "cat_3"));
        categoryList.add(new CategoryDomain("Hotdog", "cat_4"));

        adapter1 = new CategoryAdapter(categoryList);
        recyclerViewCategory.setAdapter(adapter1);
    }
}