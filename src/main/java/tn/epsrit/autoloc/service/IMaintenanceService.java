
package tn.epsrit.autoloc.service;

import java.util.List;
import tn.epsrit.autoloc.domain.enums.Maintenance;

public interface IMaintenanceService {
    Maintenance create(Maintenance maintenance);
    Maintenance findById(Long id);
    List<Maintenance> findAll();
    Maintenance update(Maintenance maintenance);
    Maintenance delete(Long id);
}