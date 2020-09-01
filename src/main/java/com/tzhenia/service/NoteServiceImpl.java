package com.tzhenia.service;

import com.tzhenia.dao.NoteDAO;
import com.tzhenia.entity.Note;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteDAO noteDAO;

    @Override
    @Transactional
    public List<Note> getNotes() {
        log.info("Get notes");
        return noteDAO.getNotes();
    }

    @Override
    @Transactional
    public void saveNote(Note note) {
        log.info("Save note {}", note);
        noteDAO.saveNote(note);
    }

    @Override
    @Transactional
    public Note getNote(Long id) {
        log.info("Get note by id: {}", id);
        return noteDAO.getNote(id);
    }

    @Override
    @Transactional
    public void deleteNote(Long id) {
        log.info("Delete note by id: {}", id);
        noteDAO.deleteNote(id);
    }
}