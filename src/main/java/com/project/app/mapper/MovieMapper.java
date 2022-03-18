/**
 * 
 */
package com.project.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.project.app.entities.Movie;
import com.project.app.requests.MovieRequest;
import com.project.app.respones.MovieResponse;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
@Mapper(componentModel = "spring")
public interface MovieMapper {
	
	MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
	
	Movie requestToEntity(MovieRequest movieRequest);
	MovieResponse entityToResponse(Movie movie);

	@Mapping(target = "author", ignore = true)
	Movie requestToEntityWithOutAuthor(MovieRequest movieRequest);
}
