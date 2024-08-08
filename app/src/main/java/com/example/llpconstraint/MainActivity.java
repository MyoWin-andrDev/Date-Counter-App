package com.example.llpconstraint;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.llpconstraint.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Animals[] animals;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();
        initListener();
    }

    private void initListener(){
        binding.btnPrevious.setOnClickListener(v -> {
            if(index == 0){
                index = animals.length -1;
            }
            else{
                index-- ;
            }
           updateInfo();
        });

        binding.btnNext.setOnClickListener(v -> {
            if(index == animals.length - 1){
                index = 0;
            }
            else{
                index++;
            }
           updateInfo();
            System.out.println(index);
        });
    }

    private void updateInfo(){
        binding.img.setImageResource(animals[index].res());
        binding.txt.setText(animals[index].name());
    }

    private void initData(){
        animals = new Animals[]{
                new Animals("Dog", R.drawable.dog),
                new Animals("Cat", R.drawable.cat),
                new Animals("Bird", R.drawable.bird),
                new Animals("Alpaca", R.drawable.alpaca),
                new Animals("Mouse", R.drawable.mouse),
        };
    }
}