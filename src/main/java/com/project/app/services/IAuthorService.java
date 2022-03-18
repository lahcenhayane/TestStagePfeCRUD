/**
 * 
 */
package com.project.app.services;

import java.util.List;

import com.project.app.requests.AuthorRequest;
import com.project.app.respones.AuthorResponse;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
public interface IAuthorService {

	/**
	 * @param id
	 * @return
	 */
	AuthorResponse getAuthorByID(long id);

	/**
	 * @return
	 */
	List<AuthorResponse> getAuthors();

	/**
	 * @param authorRequest
	 * @return
	 */
	AuthorResponse createNewAuthor(AuthorRequest authorRequest);

	/**
	 * @param authorRequest
	 * @param id
	 * @return
	 */
	AuthorResponse editAuthor(AuthorRequest authorRequest, long id);

	/**
	 * @param id
	 */
	void deleteAuthorByID(long id);

}
