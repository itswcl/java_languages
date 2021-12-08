package com.wei.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wei.languages.models.Language;
import com.wei.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	// CRUD
	// find all languages
	public List<Language> findLanguages() {
		return languageRepository.findAll();
	}
	
	// create new language
	public Language createLanguage(Language lang) {
		return languageRepository.save(lang);
	}
	
	// find 1 language
	public Language findOneLanguage(Long langId) {
		Optional<Language> optionalLang = languageRepository.findById(langId);
		if(optionalLang.isPresent()) {
			return optionalLang.get();			
		} else {
			return null;
		}
	}
	
	// Update the language
	public Language updateOneLanguage(
			Long id,
			String name, String creator, String currentVersion
			) {
		Language foundLang = findOneLanguage(id);
		if (foundLang != null) {
			foundLang.setName(name);
			foundLang.setCreator(creator);
			foundLang.setCurrentVersion(currentVersion);
			return languageRepository.save(foundLang);
		} else {
			Language notFoundLang = new Language(name, creator, currentVersion);
			return createLanguage(notFoundLang);
		}
	}
	
	// Delete the language
	public void removeOneLanguage(Long id) {
		languageRepository.deleteById(id);
	}
}
