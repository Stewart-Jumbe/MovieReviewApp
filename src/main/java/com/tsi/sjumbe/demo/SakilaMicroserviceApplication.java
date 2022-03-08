package com.tsi.sjumbe.demo;
import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")//needed for recieving request via api
@SpringBootApplication
@RestController // handles GET , POST, DELETE, PUT requests
@RequestMapping("/home")//base url
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

	@PostMapping("/Add_Language")
	public @ResponseBody
	String addLanguage(@RequestParam String name){
		Language addLanguage = new Language(name);
		languageRepository.save(addLanguage);
		return save;
	}

	//Delete a language

	@DeleteMapping("/Remove_Language/{language_id}")
	public @ResponseBody String removeLanguageByID(@PathVariable int language_id){
		languageRepository.deleteById(language_id);
		return "The language with ID "+language_id +" has been deleted";
	}

	//Request to get all languages from

	@GetMapping("/All_Languages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){

		return languageRepository.findAll();
	}

	//****LANGUAGE****////

	//****-FILMS-****////

	//@Responsebody is the response that will be given when get request is posted

	@GetMapping("/All_Films")
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepository.findAll();
	}


	@GetMapping("/Get_Film/{film_id}")
	public @ResponseBody
	Optional<Film> getFilmByID(@PathVariable int film_id){

		return filmRepository.findById(film_id);
	}


	@PostMapping("/Add_Film")
	public @ResponseBody String addFilm(@RequestParam String title, String description, String rating, int release_year, float length, int language_id ){
		Film addFilm = new Film(title,description,rating,release_year,length,language_id);
		filmRepository.save(addFilm);
		return save;
	}

	//****FILMS****////

	//****-ACTORS-****////

	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}


	@PostMapping("/Add_Actor")
	public @ResponseBody
	String addActor(@RequestParam String first_name,@RequestParam  String last_name ){
		Actor newActor = new Actor(first_name,last_name);
		actorRepository.save(newActor);
		return "New actor saved";}
	//****ACTORS****////

	//****-CATEGORIES-****////

	@GetMapping("/All_Categories")
	public @ResponseBody
	Iterable<Category>getAllCategories(){
		return categoryRepository.findAll();
	}


	//****CATEGORIES****////

	//****USerReviews****//

	@GetMapping("/All_Reviews")
	public @ResponseBody
	Iterable<UserReview>getAllReviews(){
		return userReviewRepository.findAll();
	}

	@PostMapping("/Add_Review")
	public @ResponseBody
	String addReview(@RequestParam int film_film_id,String user_review,int star_rating){
		UserReview addReview=new UserReview(film_film_id,user_review,star_rating);
		userReviewRepository.save(addReview);
		return save;
	}


	@DeleteMapping("/Remove_Review/{user_review_id}")
	public @ResponseBody String removeReviewByID(@PathVariable int user_review_id){
		userReviewRepository.deleteById(user_review_id);
		return "Deleted";
	}

	@PutMapping("/updatereview/{user_review_id}")
	public @ResponseBody
	String updateReview(@PathVariable int user_review_id, @RequestParam String user_review, int star_rating){

		UserReview updateReview = userReviewRepository.findById(user_review_id).orElseThrow(() ->new ResourceNotFoundException("Review id not found"));

		updateReview.setUser_review(user_review);
		updateReview.setStar_rating(star_rating);
		//Saving the updated info
		final UserReview updatedReview = userReviewRepository.save(updateReview);
		//Returining updated record
		return updatedReview.getUser_review() + updateReview.getStar_rating();
	}




}
