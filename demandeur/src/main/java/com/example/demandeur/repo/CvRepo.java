package com.example.demandeur.repo;

import com.example.demandeur.entity.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
public interface CvRepo  extends JpaRepository<Cv,Long> {
    Cv findEmployeByIdCv(Long idCv);









}
