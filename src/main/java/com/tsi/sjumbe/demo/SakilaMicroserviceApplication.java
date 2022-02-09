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
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	public SakilaMicroserviceApplication(LanguageRepository languageRepository,
										 FilmRepository filmRepository,
										 ActorRepository actorRepository,
										 CategoryRepository categoryRepository){
		this.languageRepository = languageRepository;
		this.filmRepository = filmRepository;
		this.actorRepository =actorRepository;
		this.categoryRepository = categoryRepository;
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
	//@Responsebody is the response that will be given when get request is posted
	@GetMapping("/allfilms")
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepository.findAll();
	}

	@GetMapping("/allactors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/allcategories")
	public @ResponseBody
	Iterable<Category>getAllCategories(){
		return categoryRepository.findAll();

	}




}
