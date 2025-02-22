package com.trycoding.hr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trycoding.hr.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
