package com.shop.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
public class UtilisateurDto {

    private Long idUser;
	
	private String username;
	
	private String password;

	private String email;
}
