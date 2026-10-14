package tn.epsrit.autoloc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.epsrit.autoloc.domain.enums.Contrat;

public interface IContratRepository extends JpaRepository<Contrat,Long> {
}
