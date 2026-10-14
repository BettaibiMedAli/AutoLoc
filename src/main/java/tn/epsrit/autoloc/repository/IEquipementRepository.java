package tn.epsrit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.epsrit.autoloc.domain.enums.Equipement;

public interface IEquipementRepository extends JpaRepository<Equipement,Long> {
}