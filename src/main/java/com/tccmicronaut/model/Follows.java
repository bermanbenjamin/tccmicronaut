package com.tccmicronaut.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.micronaut.core.annotation.Introspected;


@Entity
@Introspected
public class Follows {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private Long idUser;
	
	@NotNull
	private Long idFollowing;

	public Follows(){}

	public Follows(Long idUser, Long idFollowing) {
		super();
		this.idUser = idUser;
		this.idFollowing = idFollowing;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdFollowing() {
		return idFollowing;
	}

	public void setIdFollowing(Long idFollowing) {
		this.idFollowing = idFollowing;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

