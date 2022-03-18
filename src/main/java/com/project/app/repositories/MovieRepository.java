/**
 * 
 */
package com.project.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.app.entities.Movie;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
