package tn.epsrit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.epsrit.autoloc.domain.enums.Employe;
import tn.epsrit.autoloc.service.IEmployeService;

import java.util.List;

@Tag(name = "Employes", description = "Gestion des employés")
@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
public class EmployeController {
    private final IEmployeService employeService;

    @GetMapping
    @Operation(summary = "Consulter tous les employés")
    public List<Employe> findAll() {
        return employeService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulter un employé par son ID")
    public Employe findById(@PathVariable Long id) {
        return employeService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Créer un employé")
    @ResponseStatus(HttpStatus.CREATED)
    public Employe create(@RequestBody Employe employe) {
        return employeService.create(employe);
    }

    @PutMapping
    @Operation(summary = "Modifier un employé")
    @ResponseStatus(HttpStatus.OK)
    public Employe update(@RequestBody Employe employe) {
        return employeService.update(employe);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un employé")
    public void delete(@PathVariable Long id) {
        employeService.delete(id);
    }
}
