package com.tzhenia.dao;

import com.tzhenia.entity.Note;

import java.util.List;

public interface NoteDAO {
    List<Note> getNotes();

    void saveNote(Note note);

    Note getNote(Long id);

    void deleteNote(Long id);
}
