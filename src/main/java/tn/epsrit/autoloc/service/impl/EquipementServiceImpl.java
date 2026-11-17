
package tn.epsrit.autoloc.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import tn.epsrit.autoloc.domain.enums.Equipement;
import tn.epsrit.autoloc.exception.ResourceNotFoundException;
import tn.epsrit.autoloc.repository.IEquipementRepository;
import tn.epsrit.autoloc.service.IEquipementService;

@Service
public class EquipementServiceImpl implements IEquipementService {

    private IEquipementRepository equipementRepository;
    public EquipementServiceImpl(IEquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }
    @Override
    public Equipement findById(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipement", id));
    }

    @Override
    public List<Equipement> findAll() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement create(Equipement equipement) {
        if (equipement.getIdEquipement() != null) {
            throw new IllegalArgumentException("Un nouvel equipement ne doit pas avoir d'identifiant");
        }
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement update(Equipement equipement) {
        Equipement existing = findById(equipement.getIdEquipement());
        existing.setLibelle(equipement.getLibelle());
        return equipementRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!equipementRepository.existsById(id)) {
            throw new ResourceNotFoundException("Equipement", id);
        }
        equipementRepository.deleteById(id);
    }
}