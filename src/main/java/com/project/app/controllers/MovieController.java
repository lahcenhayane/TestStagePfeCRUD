/**
 * 
 */
package com.project.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.mapper.AuthorMapper;
import com.project.app.mapper.MovieMapper;
import com.project.app.requests.MovieRequest;
import com.project.app.respones.MovieResponse;
import com.project.app.services.IMovieService;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */

@RestController
@RequestMapping("api/v1")
public class MovieController {
	
	@Autowired
	private IMovieService movieService;
	
	
	@GetMapping("/movies")
	public ResponseEntity<List<MovieResponse>> getMovies(){
		return new ResponseEntity<List<MovieResponse>>(movieService.getMovies(), HttpStatus.OK);
	}

	@GetMapping("movie/{id}")
	public ResponseEntity<MovieResponse> getByID(@PathVariable long id){
		return new ResponseEntity<MovieResponse>(movieService.getMovieByID(id), HttpStatus.OK);
	}
	
	@PostMapping("/movie")
	public ResponseEntity<MovieResponse> createNewMovie(@RequestBody MovieRequest movieRequest){
		return new ResponseEntity<MovieResponse>(movieService.createNewMovie(movieRequest), HttpStatus.CREATED);
	}
	
	@PutMapping("/movie/{id}")
	public ResponseEntity<MovieResponse> editMovie(@RequestBody MovieRequest movieRequest, @PathVariable long id){
		return new ResponseEntity<MovieResponse>(movieService.editMovie(movieRequest, id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/movie/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable long id){
		movieService.deleteMovieById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
