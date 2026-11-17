
package tn.epsrit.autoloc.service;

import java.util.List;
import tn.epsrit.autoloc.domain.enums.Paiement;

public interface IPaiementService {
    List<Paiement> findAll();
    Paiement findById(Long id);
    Paiement create(Paiement paiement);
    Paiement update(Paiement paiement);
    Paiement delete(Long id);

}