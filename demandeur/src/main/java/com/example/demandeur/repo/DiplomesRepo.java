package com.example.demandeur.repo;

import com.example.demandeur.entity.Cv;
import com.example.demandeur.entity.Diplomes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DiplomesRepo extends JpaRepository<Diplomes , Long> {

    Diplomes findDiplomesByIdDiplome(Long idDiplome);
}

