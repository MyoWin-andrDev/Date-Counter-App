package com.example.llpconstraint.note;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.llpconstraint.R;
import com.example.llpconstraint.databinding.ActivityNoteMainBinding;
import com.example.llpconstraint.note.adapter.NoteAdapter;
import com.example.llpconstraint.note.dao.NoteDao;
import com.example.llpconstraint.note.entities.Note;

import java.util.List;

public class NoteMainActivity extends AppCompatActivity {
    private ActivityNoteMainBinding binding;
    private NoteDao noteDao;
    private List<Note> noteList;
    private NoteAdapter noteAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityNoteMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initDatabase();
        initUI();
        initListener();
    }

    private void initDatabase() {
        var database = AppDatabase.getInstance(this);
        noteDao = database.noteDao();
        noteDao.addNote(new Note("Eat Breakfast","It's time tot eat breakfast"));
        noteList = noteDao.getAllNotes();
    }
    private void initUI(){
        noteAdapter = new NoteAdapter(noteList);
        binding.recyclerView.setAdapter(noteAdapter);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }
    private void initListener(){
        binding.floatingButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, EditNoteActivity.class);
            startActivityForResult(intent,123);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123 && resultCode == RESULT_OK){
            Note note = (Note) data.getSerializableExtra("note");
            noteDao.addNote(note);
            refreshNote();
        }
    }

    private void refreshNote() {
        noteList = noteDao.getAllNotes();
        noteAdapter.setNoteList(noteList);
    }
}