
package tn.epsrit.autoloc.service.impl;

import org.springframework.stereotype.Service;
import tn.epsrit.autoloc.domain.enums.Maintenance;
import tn.epsrit.autoloc.exception.ResourceNotFoundException;
import tn.epsrit.autoloc.repository.IMaintenanceRepository;
import tn.epsrit.autoloc.service.IMaintenanceService;

@Service
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final IMaintenanceRepository maintenanceRepository;

    public MaintenanceServiceImpl(IMaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public Maintenance create(Maintenance maintenance) {
        if (maintenance.getIdMaintenance() != null) {
            throw new IllegalArgumentException("Une nouvelle maintenance ne doit pas avoir d'identifiant");
        }
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance update(Maintenance maintenance) {
        Maintenance existing = findById(maintenance.getIdMaintenance());
        existing.setDateDebut(maintenance.getDateDebut());
        existing.setDateFin(maintenance.getDateFin());
        existing.setDescription(maintenance.getDescription());
        existing.setVehicule(maintenance.getVehicule());
        return maintenanceRepository.save(existing);
    }

    @Override
    public Maintenance delete(Long id) {
        Maintenance existing = findById(id);
        maintenanceRepository.delete(existing);
        return existing;
    }

    @Override
    public Maintenance findById(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Maintenance", id));
    }

    @Override
    public java.util.List<Maintenance> findAll() {
        return maintenanceRepository.findAll();
    }
}
