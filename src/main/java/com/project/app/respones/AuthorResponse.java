/**
 * 
 */
package com.project.app.respones;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorResponse {

	private long id;
	private String name;
	
}
