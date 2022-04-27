package com.example.newsapp;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements com.example.newsapp.VerticalAdapter.OnRowClickListener{
    RecyclerView recyclerViewHorizontal;
    HorizontalAdapter horizontalAdapter;
    List<Horizontal> HorizontalList = new ArrayList<>();
    Integer[] imageListH = {R.drawable.img, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5};

    RecyclerView recyclerViewVertical;
    VerticalAdapter verticalAdapter;
    List<Vertical> VerticalList = new ArrayList<>();

    Integer[] imageList = {R.drawable.img, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5};
    String[] nameList = {"Solar panels","Elon Musk","Twitter stake","BMW","TikTok ","Diamond"};
    String[] descripList = {"Australian scientists to fit Tesla with printed solar panels in 15,000-kilometer test ride",
            "Elon Musk has become the most powerful person in the world",
            "Trump SPAC is down 44% since Elon Musk disclosed Twitter stake",
            "BMW reveals its new $120,000 electric flagship",
            "These TikTok stars built a VC firm backed by Anthony Scaramucci and the Winklevoss twins",
            "Why lab-grown diamond sales are surging"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewHorizontal = findViewById(R.id.horizontalView);
        horizontalAdapter = new HorizontalAdapter(HorizontalList, this);
        recyclerViewHorizontal.setAdapter(horizontalAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewHorizontal.setLayoutManager(layoutManager);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        for (int i = 0; i < imageListH.length; i++){
            com.example.newsapp.Horizontal horizontal = new com.example.newsapp.Horizontal(i, imageListH[i]);
            HorizontalList.add(horizontal);
        }

        recyclerViewVertical = findViewById(R.id.verticalView);
        verticalAdapter = new VerticalAdapter(VerticalList, MainActivity.this.getApplicationContext(), this);
        recyclerViewVertical.setAdapter(verticalAdapter);
        recyclerViewVertical.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < imageList.length; i++){
            com.example.newsapp.Vertical vertical = new com.example.newsapp.Vertical(i,imageList[i],nameList[i],descripList[i]);
            VerticalList.add(vertical);
        }
    }

    @Override
    public void onItemClick(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment = new Fragment1();
                break;
            case 1:
                fragment = new Fragment2();
                break;
            case 2:
                fragment = new Fragment3();
                break;
            case 3:
                fragment = new Fragment4();
                break;
            case 4:
                fragment = new Fragment5();
                break;
            case 5:
                fragment = new Fragment6();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment).commit();
    }
}