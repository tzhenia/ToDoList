package com.tzhenia.service;

import com.tzhenia.entity.Note;

import java.util.List;

public interface NoteService {
    List<Note> getNotes();

    void saveNote(Note note);

    Note getNote(Long id);

    void deleteNote(Long id);
}