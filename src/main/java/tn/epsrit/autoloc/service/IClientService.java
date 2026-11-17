
package tn.epsrit.autoloc.service;

import java.util.List;
import tn.epsrit.autoloc.domain.enums.Client;

public interface IClientService {
    Client create(Client client);
    Client update(Client client);
    Client delete(Long id);
    Client findById(Long id);
    List<Client> findAll();
}