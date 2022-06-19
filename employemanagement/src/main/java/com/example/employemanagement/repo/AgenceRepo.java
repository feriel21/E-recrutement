package com.example.employemanagement.repo;

import com.example.employemanagement.entities.Agence;
import com.example.employemanagement.entities.Employe;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AgenceRepo extends JpaRepository<Agence , Long> {



}
