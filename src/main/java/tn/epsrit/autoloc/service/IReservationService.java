
package tn.epsrit.autoloc.service;

import java.util.List;
import tn.epsrit.autoloc.domain.enums.Reservation;

public interface IReservationService {
    Reservation create(Reservation reservation);
    Reservation findById(Long id);
    List<Reservation> findAll();
    Reservation update(Reservation reservation);
    Reservation delete(Long id);
}
