package com.scifer.mihalis.repositories.models;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
@NoRepositoryBean
public interface UserRepository<T> extends R2dbcRepository<T, Long> {
}
