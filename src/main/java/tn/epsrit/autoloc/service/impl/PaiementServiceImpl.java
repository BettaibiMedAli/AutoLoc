
package tn.epsrit.autoloc.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.epsrit.autoloc.domain.enums.Contrat;
import tn.epsrit.autoloc.domain.enums.Paiement;
import tn.epsrit.autoloc.exception.ResourceNotFoundException;
import tn.epsrit.autoloc.repository.IContratRepository;
import tn.epsrit.autoloc.repository.IPaiementRepository;
import tn.epsrit.autoloc.service.IPaiementService;

@Service
public class PaiementServiceImpl implements IPaiementService {

    private final IPaiementRepository paiementRepository;
    private final IContratRepository contratRepository;

    public PaiementServiceImpl(IPaiementRepository paiementRepository, IContratRepository contratRepository) {
        this.paiementRepository = paiementRepository;
        this.contratRepository = contratRepository;
    }

    @Override
    public Paiement create(Paiement paiement) {
        if (paiement.getIdPaiement() != null) {
            throw new IllegalArgumentException("Un nouveau paiement ne doit pas avoir d'identifiant");
        }
        paiement.setContrat(resolveExistingContrat(paiement));
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement update(Paiement paiement) {
        Paiement existing = findById(paiement.getIdPaiement());
        existing.setMontant(paiement.getMontant());
        existing.setDatePaiement(paiement.getDatePaiement());
        existing.setModelPaiement(paiement.getModelPaiement());
        existing.setContrat(resolveExistingContrat(paiement));
        return paiementRepository.save(existing);
    }

    @Override
    public Paiement delete(Long id) {
        Paiement existing = findById(id);
        paiementRepository.delete(existing);
        return existing;
    }


    @Override
    public List<Paiement> findAll() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement findById(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement", id));
    }

    private Contrat resolveExistingContrat(Paiement paiement) {
        if (paiement.getContrat() == null) {
            throw new ResponseStatusException(
                    HttpStatus.METHOD_NOT_ALLOWED,
                    "Paiement sans contrat non autorisé.");
        }

        Contrat contratPayload = paiement.getContrat();
        if (contratPayload.getIdContrat() == null) {
            throw new IllegalArgumentException(
                    "La création de contrat se fait via /contrats. Pour /paiements, fournissez contrat.idContrat existant.");
        }
        Long contratId = contratPayload.getIdContrat();
        return contratRepository.findById(contratId)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat", contratId));
    }

}