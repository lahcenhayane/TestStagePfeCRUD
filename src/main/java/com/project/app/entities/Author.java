/**
 * 
 */
package com.project.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.app.respones.AuthorResponse;

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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authors")
public class Author {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
	private List<Movie> movies;
	
}
