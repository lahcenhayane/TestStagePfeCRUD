/**
 * 
 */
package com.project.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.app.entities.Author;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

	/**
	 * @param name
	 * @return
	 */
	Author findByName(String name);

}
