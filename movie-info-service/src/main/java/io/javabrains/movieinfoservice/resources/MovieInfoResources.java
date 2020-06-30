package io.javabrains.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoResources {

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		
		if(movieId.equals("1234"))
			return new Movie("1234", "Transformers");
		else if(movieId.equals("5678"))
			return new Movie("5678", "Avengers");
		
		return new Movie();
	}
}
