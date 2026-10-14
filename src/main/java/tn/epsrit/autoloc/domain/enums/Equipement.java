package tn.epsrit.autoloc.domain.enums;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEquipement;
    String libelle;

    @ManyToMany(mappedBy = "equipements")
    List<tn.esprit.autoloc.domain.Vehicule> vehicules = new ArrayList<>();
}