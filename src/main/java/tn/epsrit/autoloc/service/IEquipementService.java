
package tn.epsrit.autoloc.service;

import java.util.List;
import tn.epsrit.autoloc.domain.enums.Equipement;

public interface IEquipementService {
    Equipement findById(Long id);
    List<Equipement> findAll();
    Equipement create(Equipement equipement);
    Equipement update(Equipement equipement);
    void delete(Long id);
}
