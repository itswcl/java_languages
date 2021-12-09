package com.wei.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wei.languages.models.Language;
import com.wei.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
//	private final LanguageRepository languageRepository;
//
//	public LanguageService(LanguageRepository languageRepository) {
//		this.languageRepository = languageRepository;
//	}
	@Autowired
	private LanguageRepository languageRepository;
	
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
	
	// Update the language (no more need as we re use create to update lang
//	public Language updateOneLanguage(
//			Long id,
//			String name, String creator, String currentVersion
//			) {
//		Language foundLang = findOneLanguage(id);
//		if (foundLang != null) {
//			foundLang.setName(name);
//			foundLang.setCreator(creator);
//			foundLang.setCurrentVersion(currentVersion);
//			return languageRepository.save(foundLang);
//		} else {
//			Language notFoundLang = new Language();
//			return createLanguage(notFoundLang);
//		}
//	}

// same as create lang so we re use it as update
//	public Language updateOneLanguage2(Language lang) {
//    	return languageRepository.save(lang);
//    }
	
	// Delete the language
	public void removeOneLanguage(Long id) {
		languageRepository.deleteById(id);
	}
}
