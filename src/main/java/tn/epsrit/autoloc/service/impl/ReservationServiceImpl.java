
package tn.epsrit.autoloc.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.epsrit.autoloc.domain.enums.Contrat;
import tn.epsrit.autoloc.domain.enums.Reservation;
import tn.epsrit.autoloc.exception.ResourceNotFoundException;
import tn.epsrit.autoloc.repository.IContratRepository;
import tn.epsrit.autoloc.repository.IReservationRepository;
import tn.epsrit.autoloc.service.IReservationService;

@Service
public class ReservationServiceImpl implements IReservationService {

    private final IReservationRepository reservationRepository;
    private final IContratRepository contratRepository;

    public ReservationServiceImpl(IReservationRepository reservationRepository, IContratRepository contratRepository) {
        this.reservationRepository = reservationRepository;
        this.contratRepository = contratRepository;
    }

    private void attachManagedContrat(Reservation reservation) {
        if (reservation.getContrat() == null) {
            return;
        }

        if (reservation.getContrat().getIdContrat() == null) {
            Contrat savedContrat = contratRepository.save(reservation.getContrat());
            reservation.setContrat(savedContrat);
            return;
        }

        Contrat managedContrat = contratRepository.findById(reservation.getContrat().getIdContrat())
                .orElseThrow(() -> new ResourceNotFoundException("Contrat", reservation.getContrat().getIdContrat()));
        reservation.setContrat(managedContrat);
    }

    @Override
    public Reservation create(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            throw new IllegalArgumentException("Une nouvelle reservation ne doit pas avoir d'identifiant");
        }
        attachManagedContrat(reservation);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation update(Reservation reservation) {
        Reservation existing = findById(reservation.getIdReservation());
        existing.setDateDebut(reservation.getDateDebut());
        existing.setDateFin(reservation.getDateFin());
        existing.setStatut(reservation.getStatut());
        existing.setClient(reservation.getClient());
        existing.setVehicule(reservation.getVehicule());
        attachManagedContrat(reservation);
        existing.setContrat(reservation.getContrat());
        return reservationRepository.save(existing);
    }

    @Override
    public Reservation delete(Long id) {
        Reservation existing = findById(id);
        reservationRepository.delete(existing);
        return existing;
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", id));
    }

    @Override
    public java.util.List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}
