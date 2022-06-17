package com.example.employemanagement.controller;

import com.example.employemanagement.entities.Employe;
import com.example.employemanagement.repo.EmployeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employe-api")
public class EmployeController {

    private final Logger log = LoggerFactory.getLogger(EmployeController.class);

    @Autowired
    EmployeRepo employeRepo;

    @GetMapping("/employe/all") //GET http://localhost:8090/employe-api/employe/all
    public List<Employe> getEmployes(){
        return employeRepo.findAll() ;
    }

    @GetMapping("/employe/{id}") //GET http://localhost:8090/employe-api/employe/1
    public Employe getEmploye(@PathVariable("id") Long idEmploye){
        return employeRepo.findEmployeByIdEmploye(idEmploye) ;
    }

    @GetMapping("/{nom}") //GET http://localhost:8090/employe-api/employe/ent1
    public Employe getEmployeByName(@PathVariable("nom") String nom){
        return employeRepo.findEmployeByNom(nom) ;
    }

    //POST http://localhost:8090/employe-api/employe
    @RequestMapping(value = "/ajouterEmploye", method = RequestMethod.POST)
    public Employe createNewEmploye(@RequestBody Employe employe) {
        return employeRepo.save(employe);
    }
    //Put http://localhost:8090/employe-api/employe/ent1
    @PutMapping("/employeUpdate/{id}")
    public Employe updateEmploye(@PathVariable(value = "id") Long id,
                               @RequestBody Employe employe) {
        if (employeRepo.findById(id).isPresent()) {
            employe.setIdEmploye(id);
            return employeRepo.save(employe) ;
        }
        return null;
    }

    //Delete http://localhost:8090/employe-api/employe?active=false
    @DeleteMapping("/deleteEmploye/{id}")   //Delete http://localhost:8090/employe-api/deleteEmploye/1

    public String DeleteEmploye(@PathVariable(value = "id") Long idEmploye){

        if (employeRepo.findEmployeByIdEmploye(idEmploye).isActive()){
            employeRepo.deleteById(idEmploye);
            return "Correctly deleted";}
        return "the ID is not valid";
    }


   @RequestMapping(value = "/searchEmploye" , method =RequestMethod.GET )
   public List<Employe> getEmployeByNomOrActivityPrincipale(@RequestParam(name = "search")  String search, Model model)  {
         List<Employe> employe = employeRepo.findByNomOrActivityPrincipale(search);
       model.addAttribute("employees", employe);
     return employeRepo.findByNomOrActivityPrincipale(search) ;
    }




}