
package tn.epsrit.autoloc.service;

import java.util.List;
import tn.epsrit.autoloc.domain.enums.Employe;

public interface IEmployeService {
    Employe findById(Long id);
    List<Employe> findAll();
    Employe create(Employe employe);
    Employe update(Employe employe);
    void delete(Long id);
}
