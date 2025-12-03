package com.language_practice_server.server_demo.db.repository;

import com.language_practice_server.server_demo.db.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepositoryJpa extends JpaRepository<PersonEntity, Long> {

}
