package com.app.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VerifyMessageDTO implements Serializable{
	
	private static final long serialVersionUID = 3111038861042038562L;
	
	private String name;
	private String email;

}
