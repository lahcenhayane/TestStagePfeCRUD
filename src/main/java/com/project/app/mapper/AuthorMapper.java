/**
 * 
 */
package com.project.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.project.app.entities.Author;
import com.project.app.requests.AuthorRequest;
import com.project.app.respones.AuthorResponse;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
@Mapper(componentModel = "spring")
public interface AuthorMapper {
	
	AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
	
	
	Author requestToEntity(AuthorRequest authorRequest);
	AuthorResponse entityToResponse(Author author);

}
