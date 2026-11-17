
package tn.epsrit.autoloc.service;

import java.util.List;
import tn.epsrit.autoloc.domain.enums.Vehicule;

public interface IVehiculeService {
    Vehicule create(Vehicule vehicule);
    Vehicule update(Vehicule vehicule);
    Vehicule delete(Long id);
    Vehicule findById(Long id);
    List<Vehicule> findAll();
}