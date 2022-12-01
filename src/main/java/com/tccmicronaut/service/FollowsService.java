package com.tccmicronaut.service;

import com.tccmicronaut.model.Follows;
import com.tccmicronaut.repository.FollowsRepository;
import com.tccmicronaut.repository.UserRepository;

import io.micronaut.context.annotation.Factory;
import jakarta.inject.Inject;


import java.util.ArrayList;
import java.util.Optional;

@Factory
public class FollowsService {

	private FollowsRepository followsRepository;
	
	@Inject
	private UserRepository userRepository;

	@Inject
	public FollowsService(FollowsRepository followsRepository) {
		this.followsRepository = followsRepository;
	}

	public Follows follow(Long userFollowed, Long userFollowing) {
		try {
			Follows follow = new Follows();
			follow.setIdFollowing(userRepository.findById(userFollowing).get().getId());
			follow.setIdUser(userRepository.findById(userFollowed).get().getId());
			return followsRepository.save(follow);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao seguir usuário: \n" + e.getMessage());
		}
	}

	public void unfollow(Long id) {
		try {
			followsRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao deixar de seguir usuário: \n" + e.getMessage());
		}
	}

	public Optional<Follows> findFollowers(Long idUser) {
		try {
			ArrayList<Long> ids = new ArrayList<Long>();
			ids.add(idUser);
			return followsRepository.findById(idUser);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar seguidores: \n" + e.getMessage());
		}

	}


}
