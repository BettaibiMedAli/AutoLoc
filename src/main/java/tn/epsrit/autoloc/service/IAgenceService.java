
package tn.epsrit.autoloc.service;

import java.util.List;
import tn.epsrit.autoloc.domain.enums.Agence;

public interface IAgenceService {
    Agence findById(Long id);
    List<Agence> findAll();
    Agence create(Agence agence);
    Agence update(Agence agence);
    void delete(Long id);

}