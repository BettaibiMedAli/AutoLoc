package tn.epsrit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.epsrit.autoloc.domain.enums.Equipement;
import tn.epsrit.autoloc.service.IEquipementService;

import java.util.List;

@Tag(name = "Equipements", description = "Gestion des équipements")
@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
public class EquipementController {
    private final IEquipementService equipementService;

    @GetMapping
    @Operation(summary = "Consulter tous les équipements")
    public List<Equipement> findAll() {
        return equipementService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulter un équipement par son ID")
    public Equipement findById(@PathVariable Long id) {
        return equipementService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Créer un équipement")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipement create(@RequestBody Equipement equipement) {
        return equipementService.create(equipement);
    }

    @PutMapping
    @Operation(summary = "Modifier un équipement")
    @ResponseStatus(HttpStatus.OK)
    public Equipement update(@RequestBody Equipement equipement) {
        return equipementService.update(equipement);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un équipement")
    public void delete(@PathVariable Long id) {
        equipementService.delete(id);
    }
}