package tn.epsrit.autoloc.domain.enums;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vehicule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;
    private String immatriculation;
    private String marque;
    private String modele;
    private CategorieVehicule categorie;
    private BigDecimal tarifJournalier;
    private StatutReservation statut;

    @JsonIgnoreProperties({"employes","vehicules"})
    @ManyToOne
    Agence agence;

    @JsonIgnoreProperties(value = "vehicule", allowSetters = true)
    @OneToMany(mappedBy = "vehicule")
    List<Reservation> reservations = new ArrayList<>();

    @JsonIgnoreProperties(value = "vehicule", allowSetters = true)
    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    List<Maintenance> maintenances = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties(value = "vehicule", allowSetters = true)
    List<Equipement> equipements = new ArrayList<>();
}