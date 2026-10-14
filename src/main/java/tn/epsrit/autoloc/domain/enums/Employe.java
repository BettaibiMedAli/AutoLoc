package tn.epsrit.autoloc.domain.enums;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEmploye;
    String nom;
    String prenom;
    tn.epsrit.autoloc.domain.enums.RoleEmploye roleEmploye;

    @ManyToOne
    Agence agence;
}