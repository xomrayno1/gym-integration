package com.app.entity;

import com.app.enums.AuthProvider;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseEntity{
	private static final long serialVersionUID = 883406590734421220L;
	private String username;
	private String passwordHash;

	private String email;

	@Enumerated(EnumType.STRING)
	@Column
	private AuthProvider provider =  AuthProvider.local;

	private String providerId;
	
	@Column(columnDefinition = "text")
	private String imageUrl;


}
