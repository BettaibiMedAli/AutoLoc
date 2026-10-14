package tn.epsrit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.epsrit.autoloc.domain.enums.Maintenance;

public interface IMaintenanceRepository extends JpaRepository<Maintenance,Long> {
}
