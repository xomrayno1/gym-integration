package com.app.dto;

import java.io.Serializable;

import lombok.Data;
 
@Data
public class RegisterDTO  implements Serializable{
	private static final long serialVersionUID = 4584860828576654296L;
	
	private String email;
	private String username;
	private String password;

}
