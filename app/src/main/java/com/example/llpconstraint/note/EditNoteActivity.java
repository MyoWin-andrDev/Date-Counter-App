package com.example.llpconstraint.note;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.llpconstraint.R;
import com.example.llpconstraint.databinding.ActivityEditNoteBinding;
import com.example.llpconstraint.note.entities.Note;

public class EditNoteActivity extends AppCompatActivity {
    private ActivityEditNoteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityEditNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initListener();
    }

    private void initListener() {
        binding.btnCancel.setOnClickListener(v -> {
            finish();
        });
        binding.btnSave.setOnClickListener(v -> {
            String title = binding.etTitle.getText().toString();
            String content = binding.etContent.getText().toString();
            if(!title.isBlank() && !content.isBlank()){
                Note note = new Note(title,content);
                Intent intent = new Intent();
                intent.putExtra("note",note);
                setResult(RESULT_OK,intent);
                finish();
            }
            else{
                Toast.makeText(this, "Please Fill The Input", Toast.LENGTH_SHORT).show();
            }
        });
    }
}