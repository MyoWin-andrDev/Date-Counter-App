package com.example.llpconstraint.note.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.llpconstraint.note.entities.Note;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    void addNote(Note note);
    @Update
    void updateNote(Note note);
    @Delete
    void deleteNote(Note note);
    @Query("SELECT * FROM tableNote")
    List<Note> getAllNotes();
}
