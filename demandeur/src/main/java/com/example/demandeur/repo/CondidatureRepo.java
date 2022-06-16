package com.example.demandeur.repo;

import com.example.demandeur.entity.Condidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface CondidatureRepo extends JpaRepository<Condidature,Long>{

}