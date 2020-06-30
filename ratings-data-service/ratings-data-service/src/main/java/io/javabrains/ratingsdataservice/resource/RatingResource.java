package io.javabrains.ratingsdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ratingsdataservice.model.Rating;
import io.javabrains.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	
	@RequestMapping("/{movieId}")
	public UserRating getRating(@PathVariable("movieId") String movieId) {
		
		 List<Rating> rating = Arrays.asList(
				 new Rating("1234", 3),
				 new Rating("5678", 4)
			);
		
		 UserRating userRating = new UserRating();
		 userRating.setUserRating(rating);
		 
		return userRating; 
	}
}
