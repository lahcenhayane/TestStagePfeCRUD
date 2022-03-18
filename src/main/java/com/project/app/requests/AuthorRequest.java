/**
 * 
 */
package com.project.app.requests;

import com.project.app.entities.Author;

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
public class AuthorRequest {
	
	private String name;
	
}
