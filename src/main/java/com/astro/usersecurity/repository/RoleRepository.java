package com.astro.usersecurity.repository;

import java.util.Optional;

import com.astro.usersecurity.entity.ERole;
import com.astro.usersecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
