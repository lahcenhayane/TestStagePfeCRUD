/**
 * 
 */
package com.project.app.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.entities.Author;
import com.project.app.mapper.AuthorMapper;
import com.project.app.repositories.AuthorRepository;
import com.project.app.requests.AuthorRequest;
import com.project.app.respones.AuthorResponse;
import com.project.app.services.IAuthorService;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
@Service
public class AuthorServiceImpl implements IAuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private AuthorMapper authorMapper;
	

	@Override
	public AuthorResponse getAuthorByID(long id) {
		return authorMapper.entityToResponse(checkAuthor(id));
	}

	@Override
	public List<AuthorResponse> getAuthors() {
		return authorRepository.findAll().stream().map(authorMapper::entityToResponse).collect(Collectors.toList());
	}

	@Override
	public AuthorResponse createNewAuthor(AuthorRequest authorRequest) {
		return authorMapper.entityToResponse(authorRepository.save(authorMapper.requestToEntity(authorRequest)));
	}

	@Override
	public AuthorResponse editAuthor(AuthorRequest authorRequest, long id) {
		Author author = checkAuthor(id);
		author.setName(authorRequest.getName());
		return authorMapper.entityToResponse(authorRepository.save(author));
	}

	@Override
	public void deleteAuthorByID(long id) {
		authorRepository.delete(this.checkAuthor(id));
	}
	
	

	/**
	 * @param id
	 * @return
	 */
	private Author checkAuthor(long id) {
		Author author = authorRepository.getById(id);
		if (author == null) throw new RuntimeException("Author not found.");
		return author;
	}


}
