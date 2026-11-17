package tn.epsrit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.epsrit.autoloc.domain.enums.Reservation;
import tn.epsrit.autoloc.service.IReservationService;

import java.util.List;

@Tag(name = "Reservations", description = "Gestion des réservations")
@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final IReservationService reservationService;

    @GetMapping
    @Operation(summary = "Consulter toutes les réservations")
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulter une réservation par son ID")
    public Reservation findById(@PathVariable Long id) {
        return reservationService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Créer une réservation")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation create(@RequestBody Reservation reservation) {
        return reservationService.create(reservation);
    }

    @PutMapping
    @Operation(summary = "Modifier une réservation")
    @ResponseStatus(HttpStatus.OK)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une réservation")
    public void delete(@PathVariable Long id) {
        reservationService.delete(id);
    }
}