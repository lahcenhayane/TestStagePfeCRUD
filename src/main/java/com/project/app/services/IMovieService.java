/**
 * 
 */
package com.project.app.services;

import java.util.List;

import com.project.app.requests.MovieRequest;
import com.project.app.respones.MovieResponse;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
public interface IMovieService {

	/**
	 * @return
	 */
	List<MovieResponse> getMovies();

	/**
	 * @param id
	 * @return
	 */
	MovieResponse getMovieByID(long id);

	/**
	 * @param movieRequest
	 * @return
	 */
	MovieResponse createNewMovie(MovieRequest movieRequest);

	/**
	 * @param movieRequest
	 * @param id
	 * @return
	 */
	MovieResponse editMovie(MovieRequest movieRequest, long id);

	/**
	 * @param id
	 */
	void deleteMovieById(long id);

}
