package tn.epsrit.autoloc.domain.enums;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReservation;
    LocalDate dateDebut;
    LocalDate dateFin;
    tn.epsrit.autoloc.domain.enums.StatutReservation statut;

    @ManyToOne
    private Client client;

    @ManyToOne
    tn.esprit.autoloc.domain.Vehicule vehicule;

    @OneToOne(cascade = CascadeType.ALL)
    Contrat contrat;
}