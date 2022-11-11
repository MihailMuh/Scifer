package com.mihalis.scifer.repositories.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
@NoRepositoryBean
public interface UserRepository<T> extends JpaRepository<T, Long> {
}
