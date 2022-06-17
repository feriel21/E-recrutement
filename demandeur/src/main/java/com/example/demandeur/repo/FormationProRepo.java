package com.example.demandeur.repo;

import com.example.demandeur.entity.FormationPro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FormationProRepo extends JpaRepository<FormationPro , Long> {
    FormationPro findFormationProByIdFormationPro(Long idFormationPro);
}
