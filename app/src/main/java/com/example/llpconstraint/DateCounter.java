package com.example.llpconstraint;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
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
    private  AlertDialog alertDialog;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityDateCounterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUI();
        initDialog();
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

    private void initDialog(){
        var dialogBinding = DialogInputBinding.inflate(getLayoutInflater());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        alertDialog = builder
                .setView(dialogBinding.getRoot())
                //This is Title and message dialog
//                .setTitle("This is a dialog")
//                .setMessage("I am a custom dialog for date counter")

                //This is to another view
                .setCancelable(false)

                //Commenting toast message of dialog
//                .setPositiveButton("OK", (dialog1, which) -> Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show())
//                .setNegativeButton("Cancel",((dialog1, which) -> {Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();}))
                .create();

        dialogBinding.btnOK.setOnClickListener(v -> {
            // Toast.makeText(this, dialogBinding.etInput.getText().toString(), Toast.LENGTH_LONG).show();
            binding.tvJerry.setText(dialogBinding.etInput.getText().toString());
            alertDialog.cancel();
        });

        dialogBinding.btnCancel.setOnClickListener(v -> {
            alertDialog.cancel();
        });

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
                showCustomDialog(name);
            }
        }


        binding.tvTom.setOnClickListener( v ->  showCustomDialog("Tom"));
        binding.tvJerry.setOnClickListener(v ->  showCustomDialog("Jerry"));
    }

    private void showCustomDialog(String name) {

        switch(name){
            "Tom" -> {}
            "Jerry" ->
        }

        alertDialog.show();
    }

}