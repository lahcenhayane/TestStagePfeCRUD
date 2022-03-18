/**
 * 
 */
package com.project.app.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.entities.Author;
import com.project.app.entities.Movie;
import com.project.app.mapper.AuthorMapper;
import com.project.app.mapper.MovieMapper;
import com.project.app.repositories.AuthorRepository;
import com.project.app.repositories.MovieRepository;
import com.project.app.requests.MovieRequest;
import com.project.app.respones.MovieResponse;
import com.project.app.services.IMovieService;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
@Service
public class MovieServiceImpl implements IMovieService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private AuthorMapper authorMapper;
	
	@Autowired
	private MovieMapper movieMapper;

	@Override
	public List<MovieResponse> getMovies() {
		return movieRepository.findAll().stream().map(movieMapper::entityToResponse).collect(Collectors.toList());
	}

	@Override
	public MovieResponse getMovieByID(long id) {
		return movieMapper.entityToResponse(checkMovie(id));
	}

	@Override
	public MovieResponse createNewMovie(MovieRequest movieRequest) {
		Movie movie = movieMapper.requestToEntity(movieRequest);
		
		
		Author author = authorRepository.findByName(movieRequest.getAuthor().getName());
		if (author == null) {
			author = authorMapper.requestToEntity(movieRequest.getAuthor());
			author = authorRepository.save(author);
		}
		movie.setAuthor(author);
//		movie = movieRepository.save(movie);
		return movieMapper.entityToResponse(movieRepository.save(movie));
	}

	@Override
	public MovieResponse editMovie(MovieRequest movieRequest, long id) {
		Movie movie = this.checkMovie(id);
		movie.setDescription(movieRequest.getDescription());
		movie.setTitle(movieRequest.getTitle());
		movie.getAuthor().setName(movieRequest.getAuthor().getName());
		return movieMapper.entityToResponse(movieRepository.save(movie));
	}

	@Override
	public void deleteMovieById(long id) {
		movieRepository.delete(checkMovie(id));
	}
	

	/**
	 * @param id
	 * @return
	 */
	private Movie checkMovie(long id) {
		return movieRepository.findById(id).orElseThrow(()->new RuntimeException("Movie not found."));
	}
	
}
