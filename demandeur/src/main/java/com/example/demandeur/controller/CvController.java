package com.example.demandeur.controller;


import com.example.demandeur.entity.Cv;
import com.example.demandeur.repo.CvRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api2")

public class CvController {






    @Autowired
    CvRepo cvRepo;




        @RequestMapping(value = "/ajouterCv", method = RequestMethod.POST)
    public Cv createNewCv(@RequestBody Cv cv  ) {
        return cvRepo.save(cv);
    }

        @PutMapping("/updateCv/{id}")  //Put http://localhost:8081/api/cv/1
        public Cv updateCv(@PathVariable(value = "id") Long idCv,
                @RequestBody Cv Cv) {
            if (cvRepo.findById(idCv).isPresent()) {
                Cv.setIdCv(idCv);
                return cvRepo.save(Cv);
            }
            return null;
        }


    @GetMapping("/{id}")
    public Cv getCv(@PathVariable("id") Long idCv){
        return cvRepo.findEmployeByIdCv(idCv) ;
    }

    @DeleteMapping("/deleteCv/{id}")   //Delete http://localhost:8090/employe-api/deleteEmploye/1

    public String DeleteCv(@PathVariable(value = "id") Long idCv){

        if (cvRepo.findById(idCv).isPresent()){
            cvRepo.deleteById(idCv);
            return "Correctly deleted";}
        return "the ID is not valid";
    }


    }









    // @GetMapping(value = "/{id}/exportpdf", produces = MediaType.APPLICATION_PDF_VALUE)
    //public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {

      //  List<Cv> allEmployees = CvRepo.findAll();

    //    ByteArrayInputStream bis = ExportPdf.CvReport(allEmployees);
    //    HttpHeaders headers = new HttpHeaders();

     //   headers.add("Content-Disposition", "attachment;filename=Cv.pdf");

     //   return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
        //        .body(new InputStreamResource(bis));
    //}


