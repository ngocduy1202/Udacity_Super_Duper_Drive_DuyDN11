package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.model.FileForm;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("note")
public class NoteController {
    private final NoteService noteService;
    private final UserService userService;

    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping()
    public String getHomePage( Authentication authentication,@ModelAttribute("newFile")FileForm newFile, @ModelAttribute("newNote")NoteForm newNote,
                              @ModelAttribute("newCredential")CredentialForm credentialForm, Model model){
        model.addAttribute("notes", this.noteService.getNotesByUser(getUserId(authentication)));
        return "home";
    }

    @PostMapping("add-note")
    public String addNote(Authentication authentication,@ModelAttribute("newFile")FileForm newFile, @ModelAttribute("newNote")NoteForm newNote,
                          @ModelAttribute("newCredential")CredentialForm credentialForm, Model model){
        String userName = authentication.getName();
        String title = newNote.getTitle();
        String description = newNote.getDescription();
        String noteId = newNote.getNoteId();

        if(noteId.isEmpty()){
            noteService.addNote(title,description,userName);
        }else{
            noteService.updateNote(Integer.parseInt(noteId),title, description);
        }

        model.addAttribute("notes", noteService.getNotesByUser(getUserId(authentication)));

        return "home";
    }

    @GetMapping("/delete-note/{noteId}")
    public String deleteNote(Authentication authentication, @ModelAttribute("newFile")FileForm newFile, @ModelAttribute("newNote")NoteForm newNote,
                             @ModelAttribute("newCredential")CredentialForm credentialForm, Model model, @PathVariable Integer noteId){
        noteService.deleteNote(noteId);
        Integer userId = getUserId(authentication);
        model.addAttribute("notes", noteService.getNotesByUser(userId));
        return "home";
    }

    public int getUserId(Authentication authentication){
        return userService.getUserByName(authentication.getName()).getUserId();
    }

}
