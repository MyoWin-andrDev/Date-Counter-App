package com.example.llpconstraint;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.llpconstraint.databinding.ActivityDateCounterBinding;
import com.example.llpconstraint.databinding.DialogInputBinding;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Locale;

public class DateCounter extends AppCompatActivity {

    private ActivityDateCounterBinding binding;
    private DatePickerDialog datePickerDialog;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityDateCounterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUI();
        initListener();
    }


    private void initUI() {
        //dd/MM/Year
        datePickerDialog = new DatePickerDialog(this);
        datePickerDialog.setOnDateSetListener((view, year, month, dayOfMonth) -> {
            var selectedDate = LocalDate.of(year, month + 1, dayOfMonth);
            binding.btnDate.setText(formatter.format(selectedDate));
            updateDate();
        });
        updateDate();
    }

    private void updateDate(){
        var date = LocalDate.parse(binding.btnDate.getText().toString() , formatter);
        var todayDate = LocalDate.now();
        var differenceDate = todayDate.toEpochDay() - date.toEpochDay();
        binding.tvDate.setText(String.valueOf(differenceDate + "Days"));
    }

    private void initListener() {
        binding.btnDate.setOnClickListener(v -> {
           datePickerDialog.show();
        });

        class OnTextClickListener implements View.OnClickListener{

            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        }


        binding.tvTom.setOnClickListener(v -> {});
        binding.tvJerry.setOnClickListener(v -> {});
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("This is a dialog").setMessage("I am a custom dialog for date counter").create();
    }

}