package tn.epsrit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.epsrit.autoloc.domain.enums.Paiement;
import tn.epsrit.autoloc.service.IPaiementService;

import java.util.List;

@Tag(name = "Paiements", description = "Gestion des paiements")
@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
public class PaiementController {
    private final IPaiementService paiementService;

    @GetMapping
    @Operation(summary = "Consulter tous les paiements")
    public List<Paiement> findAll() {
        return paiementService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulter un paiement par son ID")
    public Paiement findById(@PathVariable Long id) {
        return paiementService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Créer un paiement")
    @ResponseStatus(HttpStatus.CREATED)
    public Paiement create(@RequestBody Paiement paiement) {
        return paiementService.create(paiement);
    }

    @PutMapping
    @Operation(summary = "Modifier un paiement")
    @ResponseStatus(HttpStatus.OK)
    public Paiement update(@RequestBody Paiement paiement) {
        return paiementService.update(paiement);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un paiement")
    public void delete(@PathVariable Long id) {
        paiementService.delete(id);
    }
}
