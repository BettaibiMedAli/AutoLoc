package tn.epsrit.autoloc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.epsrit.autoloc.domain.enums.Paiement;

public interface IPaiementRepository extends JpaRepository<Paiement,Long> {
}
