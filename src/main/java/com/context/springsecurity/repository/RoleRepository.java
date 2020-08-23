package com.context.springsecurity.repository;

import java.util.Optional;

import com.context.springsecurity.models.ERole;
import com.context.springsecurity.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);

	Boolean existsByName(ERole name);
}
