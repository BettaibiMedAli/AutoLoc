package tn.epsrit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.epsrit.autoloc.domain.enums.Agence;

public interface IAgenceRepository extends JpaRepository<Agence,Long> {
}