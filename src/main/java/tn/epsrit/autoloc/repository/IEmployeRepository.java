package tn.epsrit.autoloc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.epsrit.autoloc.domain.enums.Employe;

public interface IEmployeRepository extends JpaRepository<Employe,Long> {
}