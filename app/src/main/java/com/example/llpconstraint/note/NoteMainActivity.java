package com.example.llpconstraint.note;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.llpconstraint.R;
import com.example.llpconstraint.databinding.ActivityNoteMainBinding;

public class NoteMainActivity extends AppCompatActivity {
    private ActivityNoteMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityNoteMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}