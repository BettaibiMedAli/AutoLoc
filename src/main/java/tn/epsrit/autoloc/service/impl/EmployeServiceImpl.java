
package tn.epsrit.autoloc.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import tn.epsrit.autoloc.domain.enums.Agence;
import tn.epsrit.autoloc.domain.enums.Employe;
import tn.epsrit.autoloc.exception.ResourceNotFoundException;
import tn.epsrit.autoloc.repository.IAgenceRepository;
import tn.epsrit.autoloc.repository.IEmployeRepository;
import tn.epsrit.autoloc.service.IEmployeService;

@Service
public class EmployeServiceImpl implements IEmployeService {

    private final IEmployeRepository employeRepository;
    private final IAgenceRepository agenceRepository;

    public EmployeServiceImpl(IEmployeRepository employeRepository,
                              IAgenceRepository agenceRepository) {
        this.employeRepository = employeRepository;
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Employe findById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employe", id));
    }

    @Override
    public List<Employe> findAll() {
        return employeRepository.findAll();
    }

    /**
     * Resolves the Agence from the DB by ID so Hibernate treats it as a managed
     * entity — avoids the FK constraint violation that occurs when a transient
     * (JSON-deserialized) Agence object is used directly.
     */
    private Agence resolveAgence(Agence agence) {
        if (agence == null || agence.getIdAgence() == null) {
            return null;
        }
        return agenceRepository.findById(agence.getIdAgence())
                .orElseThrow(() -> new ResourceNotFoundException("Agence", agence.getIdAgence()));
    }

    @Override
    public Employe create(Employe employe) {
        if (employe.getIdEmploye() != null) {
            throw new IllegalArgumentException("Un nouvel employe ne doit pas avoir d'identifiant");
        }
        employe.setAgence(resolveAgence(employe.getAgence()));
        return employeRepository.save(employe);
    }

    @Override
    public Employe update(Employe employe) {
        Employe existing = findById(employe.getIdEmploye());
        existing.setNom(employe.getNom());
        existing.setPrenom(employe.getPrenom());
        existing.setRoleEmploye(employe.getRoleEmploye());
        existing.setAgence(resolveAgence(employe.getAgence()));
        return employeRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!employeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employe", id);
        }
        employeRepository.deleteById(id);
    }
}