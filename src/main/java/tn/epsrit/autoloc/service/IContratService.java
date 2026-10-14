package tn.epsrit.autoloc.service;

import tn.epsrit.autoloc.domain.enums.Contrat;

import java.util.List;
public interface IContratService {
    Contrat create(Contrat contrat);
    Contrat findById(Long id);
    List<Contrat> findAll();
    Contrat update(Long id, Contrat contrat);
    void deleteById(Long id);
}