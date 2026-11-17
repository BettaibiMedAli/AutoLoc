package tn.esprit.autoloc.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.epsrit.autoloc.domain.enums.Contrat;
import tn.epsrit.autoloc.service.IContratService;

import java.util.List;

@Tag(name = "Contrats", description = "Gestion des contrats de location")
@RestController
@RequestMapping("/contrats")
@RequiredArgsConstructor
public class ContratController {
    private final IContratService contratService;

    @GetMapping
    @Operation(summary = "Consulter tous les contrats")
    public List<Contrat> findAll() {
        return contratService.findAll();
    }

    @Operation(summary = "Consulter un contrat par son ID")
    @GetMapping("/{id}")
    public Contrat findById(@PathVariable Long id) {
        return contratService.findById(id);
    }

    @Operation(summary = "Créer un contrat")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contrat create(@RequestBody Contrat contrat) {
        return contratService.create(contrat);
    }

    @Operation(summary = "Modifier un contrat")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public Contrat update(@RequestBody Contrat contrat) {
        return contratService.update(contrat.getIdContrat(), contrat);
    }

    @Operation(summary = "Supprimer un contrat")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contratService.deleteById(id);
    }
}