package tn.epsrit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.epsrit.autoloc.domain.enums.Vehicule;

public interface IVehiculeRepository extends JpaRepository<Vehicule,Long> {
}
