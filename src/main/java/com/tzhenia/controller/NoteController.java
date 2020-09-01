package com.tzhenia.controller;

import com.tzhenia.entity.Note;
import com.tzhenia.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public String getNotes(Model model) {
        List<Note> notes = noteService.getNotes();
        model.addAttribute("notes", notes);
        return "list";
    }

    @GetMapping("/add")
    public String addNote(Model model) {
        Note note = new Note();
        model.addAttribute("note", note);
        return "form";
    }

    @PostMapping("/save")
    public String saveNote(@ModelAttribute("note") Note note) {
        noteService.saveNote(note);
        return "redirect:/note/list";
    }

    @GetMapping("/update")
    public String updateNote(@RequestParam("id") Long id, Model model) {
        Note note = noteService.getNote(id);
        model.addAttribute("note", note);
        return "form";
    }

    @GetMapping("/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        noteService.deleteNote(id);
        return "redirect:/note/list";
    }
}