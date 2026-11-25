package tn.epsrit.autoloc.domain.enums;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAgence;
    String nom;
    String ville;
    String adresse;
    String telephone;

    @JsonIgnoreProperties(value = "agence", allowSetters = true)
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    List<Employe> employes = new ArrayList<>();

    @JsonIgnoreProperties(value = "agence", allowSetters = true)
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    List<Vehicule> vehicules = new ArrayList<>();
}