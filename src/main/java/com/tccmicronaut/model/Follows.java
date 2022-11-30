package com.tccmicronaut.model;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

import javax.validation.constraints.NotNull;

@MappedEntity
public class Follows {
	
	@Id
	@GeneratedValue(GeneratedValue.Type.AUTO)
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

