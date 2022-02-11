package com.tsi.sjumbe.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

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
	@Autowired
	private UserReviewRepository userReviewRepository;

	private String save="save";

	public SakilaMicroserviceApplication(LanguageRepository languageRepository,
										 FilmRepository filmRepository,
										 ActorRepository actorRepository,
										 CategoryRepository categoryRepository,
										UserReviewRepository userReviewRepository
										 ){

		this.languageRepository = languageRepository;
		this.filmRepository = filmRepository;
		this.actorRepository =actorRepository;
		this.categoryRepository = categoryRepository;
		this.userReviewRepository = userReviewRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(SakilaMicroserviceApplication.class, args);
	}

	//****-LANGUAGE-****////
	@PostMapping("/newlanguage")
	public @ResponseBody
	String addLanguage(@RequestParam String name){
		Language addLanguage = new Language(name);
		languageRepository.save(addLanguage);
		return save;
	}

	//Delete a language
	@DeleteMapping("/removelanguage/{language_id}")
	public @ResponseBody String removeLanguageByID(@PathVariable int language_id){
		languageRepository.deleteById(language_id);
		return "The language with ID "+language_id +" has been deleted";
	}

	//Request to get all languages from
	@GetMapping("/alllanguages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();
	}

	//****LANGUAGE****////

	//****-FILMS-****////

	//@Responsebody is the response that will be given when get request is posted
	@GetMapping("/allfilms")
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepository.findAll();
	}

	@GetMapping("/getfilm/{film_id}")
	public @ResponseBody
	Optional<Film> getFilmByID(@PathVariable int film_id){
		return filmRepository.findById(film_id);
	}


	@PostMapping("/addfilm")
	public @ResponseBody String addFilm(@RequestParam String title, String description, String rating, int release_year, int length, int language_id ){
		Film addFilm = new Film(title,description,rating,release_year,length,language_id);
		filmRepository.save(addFilm);
		return save;
	}

	//****FILMS****////

	//****-ACTORS-****////
	@GetMapping("/allactors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	@PostMapping("/newactor")
	public @ResponseBody
	String addActor(@RequestParam String first_name,@RequestParam  String last_name ){
		Actor newActor = new Actor(first_name,last_name);
		actorRepository.save(newActor);
		return "New actor saved";}
	//****ACTORS****////

	//****-CATEGORIES-****////
	@GetMapping("/allcategories")
	public @ResponseBody
	Iterable<Category>getAllCategories(){
		return categoryRepository.findAll();
	}


	//****CATEGORIES****////

	//-USerReviews-//
	@PostMapping("/addreview")
	public @ResponseBody
	String addReview(@RequestParam String userReview, int film_film_id){
		UserReview addReview=new UserReview(userReview,film_film_id);
		userReviewRepository.save(addReview);
		return save;
	}

	@DeleteMapping("/removereview/{user_review_id}")
	public @ResponseBody String removeReviewByID(@PathVariable int user_review_id){
		userReviewRepository.deleteById(user_review_id);
		return "The review with ID "+user_review_id +" has been deleted";
	}






}
