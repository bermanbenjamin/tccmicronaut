package com.tccmicronaut.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import com.tccmicronaut.model.Follows;

@Repository
public interface FollowsRepository extends CrudRepository<Follows, Long> {
	
} 