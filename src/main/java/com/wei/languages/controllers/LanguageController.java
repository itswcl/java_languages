package com.wei.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.wei.languages.models.Language;
import com.wei.languages.services.LanguageService;

@Controller
public class LanguageController {
	
	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/languages";
	}
	
	// READ ALL + GET route for create request
	@GetMapping("/languages")
	public String allLanguages(Model model,
			// this is for POST request form from jsp
			@ModelAttribute("language") Language language
			) {
		
	List<Language> languages = languageService.findLanguages();
	model.addAttribute("languages",languages);
		return "index.jsp";
	}
	
	// CREATE - POST route
	@PostMapping("/languages")
	public String createLanguage(
			@Valid
			@ModelAttribute("language") Language language,
			BindingResult result,
			Model model
			) {
		if (!result.hasErrors()) {
			languageService.createLanguage(language);
			return "redirect:/languages";
		} else {
			List<Language> languages = languageService.findLanguages();
			model.addAttribute("languages", languages);
		}
		
		return "index.jsp";
	}
	
	// READ ONE
	@GetMapping("/languages/{langId}")
	public String oneLanguage(@PathVariable("langId") Long langId, Model model) {
		Language language = languageService.findOneLanguage(langId);
		model.addAttribute("language", language);
		return "show.jsp";
	}
	
	// DELETE ONE
	@DeleteMapping("/languages/{langId}")
	public String deleteLanguage(@PathVariable("langId") Long langID) {
		languageService.removeOneLanguage(langID);
		return "redirect:/languages";
	}
	
	// ----- EDIT ----
	// GET route for display update information
	@GetMapping("/languages/{id}/edit")
	public String editRoute(
			@PathVariable("id") Long id,
			Model model) {
		Language language = languageService.findOneLanguage(id);
		model.addAttribute("language", language);
		System.out.println(language.getId());
		return "edit.jsp";
	}
	
	// PUT route for edit update information
	@PutMapping("/languages/{id}")
	public String editRequest(
			@Valid @ModelAttribute("language") Language language,
			BindingResult result
			) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
    		System.out.println(language.getId());
    		// re use create Language to update same ID pass in
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
	}
}
