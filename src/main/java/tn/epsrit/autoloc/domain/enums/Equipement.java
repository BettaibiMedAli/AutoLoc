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
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEquipement;
    String libelle;

    @JsonIgnoreProperties(value = {"equipements","agence","reservations","maintenances"}, allowSetters = true)
    @ManyToMany(mappedBy = "equipements")
    List<Vehicule> vehicules = new ArrayList<>();
}