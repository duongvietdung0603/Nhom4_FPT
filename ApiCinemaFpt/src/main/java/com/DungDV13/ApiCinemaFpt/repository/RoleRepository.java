package com.DungDV13.ApiCinemaFpt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DungDV13.ApiCinemaFpt.model.Role;
import com.DungDV13.ApiCinemaFpt.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}