package com.example.llpconstraint.note;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.llpconstraint.R;
import com.example.llpconstraint.databinding.ActivityNoteMainBinding;
import com.example.llpconstraint.note.dao.NoteDao;
import com.example.llpconstraint.note.entities.Note;

import java.util.List;

public class NoteMainActivity extends AppCompatActivity {
    private ActivityNoteMainBinding binding;
    private NoteDao noteDao;
    private List<Note> noteList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityNoteMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initDatabase();
    }

    private void initDatabase() {
        var database = AppDatabase.getInstance(this);
        noteDao = database.noteDao();
    }
}