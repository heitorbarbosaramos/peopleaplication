package com.heitor.personapi.repository;

import com.heitor.personapi.entity.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRoleRepository extends JpaRepository<PersonRole, String> {
}
