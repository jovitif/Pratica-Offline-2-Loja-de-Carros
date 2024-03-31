package com.jovitif.carstore.backend.auth.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jovitif.carstore.backend.auth.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

}