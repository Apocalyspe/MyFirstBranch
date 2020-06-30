package io.javabrains.moviecatalogservice.resource;

import io.javabrains.moviecatalogservice.model.CatalogItem;
import io.javabrains.moviecatalogservice.model.Movie;
import io.javabrains.moviecatalogservice.model.UserRating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

    	
		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/" + userId, UserRating.class);
		
	//	MovieList movieList = restTemplate.getForObject("http://localhost:8081/movies/" , MovieList.class);
		
	//	MovieList movieList = restTemplate.getForObject("http://localhost:8081/movies/foo"+ userId , MovieList.class);
		
    
    	return ratings.getUserRating().stream().map(rating-> {
    		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
    		return new CatalogItem(movie.getName(), "Desc", rating.getRating());
		})
    		.collect(Collectors.toList());
    }
}

//rating.getMovieId()
//return new CatalogItem(req.getMovieid(),"desc", rating.getRating());
//