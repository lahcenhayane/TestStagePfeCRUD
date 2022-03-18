/**
 * 
 */
package com.project.app.respones;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.project.app.entities.Author;
import com.project.app.entities.Movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {
	
	
	private long id;
	private String title;
	private String description;
	private AuthorResponse author;

}
