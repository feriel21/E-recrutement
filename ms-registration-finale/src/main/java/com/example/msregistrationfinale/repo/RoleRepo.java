package com.example.msregistrationfinale.repo;


import com.example.msregistrationfinale.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
