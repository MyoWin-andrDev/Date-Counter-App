package com.example.llpconstraint.note;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.llpconstraint.note.dao.NoteDao;
import com.example.llpconstraint.note.entities.Note;

@Database(entities = {Note.class} , version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();
    private static AppDatabase appDatabase;
    public synchronized static AppDatabase getInstance(Context context){
        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(context, AppDatabase.class,"my_note_application").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
