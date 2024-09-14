package com.example.llpconstraint.note.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.llpconstraint.databinding.AdapterNoteBinding;
import com.example.llpconstraint.note.entities.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private List<Note> noteList;
    public NoteAdapter(List<Note> noteList){
        this.noteList = noteList;
    }
    class NoteViewHolder extends RecyclerView.ViewHolder{
        AdapterNoteBinding binding;
        public NoteViewHolder(AdapterNoteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        var binding = AdapterNoteBinding.inflate(layoutInflater,parent,false);
        return new NoteViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        var note = noteList.get(position);
        holder.binding.txtName.setText(note.getTitle());
        holder.binding.txtContent.setText(note.getContent());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }


}
