package com.tsi.sjumbe.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/home")
public class SakilaMicroserviceApplication {

	@Autowired
	private LanguageRepository languageRepository;

	public SakilaMicroserviceApplication(LanguageRepository languageRepository){
		this.languageRepository = languageRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SakilaMicroserviceApplication.class, args);
	}

	//Request to get all languages from
@GetMapping("/alllanguages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();

}

}
