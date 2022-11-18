package com.tccmicronaut.repository;

import com.tccmicronaut.model.User;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.ArrayList;

@JdbcRepository(dialect = Dialect.H2)
public interface UserRepository extends CrudRepository<User, String> {
}
