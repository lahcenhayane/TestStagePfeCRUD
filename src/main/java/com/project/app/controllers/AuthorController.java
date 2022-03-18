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
import com.project.app.repositories.AuthorRepository;
import com.project.app.requests.AuthorRequest;
import com.project.app.respones.AuthorResponse;
import com.project.app.services.IAuthorService;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */

@RestController
@RequestMapping("api/v1")
public class AuthorController {

	@Autowired
	private IAuthorService authorService;
	
	
	@GetMapping("/author/{id}")
	public ResponseEntity<AuthorResponse> getByID(@PathVariable long id){
		return new ResponseEntity<AuthorResponse>(authorService.getAuthorByID(id), HttpStatus.OK);
	}
	
	@GetMapping("/authors")
	public ResponseEntity<List<AuthorResponse>> getAuthors(){
		return new ResponseEntity<List<AuthorResponse>>(authorService.getAuthors(), HttpStatus.OK);
	}
	
	@PostMapping("/author")
	public ResponseEntity<AuthorResponse> createNewAuthor(@RequestBody AuthorRequest authorRequest){
		return new ResponseEntity<AuthorResponse>(authorService.createNewAuthor(authorRequest), HttpStatus.CREATED);
	}
	
	@PutMapping("/author/{id}")
	public ResponseEntity<AuthorResponse> editAuthor(@RequestBody AuthorRequest authorRequest, @PathVariable long id){
		return new ResponseEntity<AuthorResponse>(authorService.editAuthor(authorRequest, id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/author/{id}")
	public ResponseEntity<?> deleteAuthorByID(@PathVariable long id){
		authorService.deleteAuthorByID(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
