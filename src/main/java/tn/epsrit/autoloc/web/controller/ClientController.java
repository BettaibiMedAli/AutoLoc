package tn.epsrit.autoloc.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.epsrit.autoloc.domain.enums.Client;
import tn.epsrit.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final IClientService clientService;

    @GetMapping
    public List<Client> findAll()
    {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id)
    {
        return clientService.findById(id);
    }

    @PostMapping
    public Client save(@RequestBody Client client){
        return clientService.create(client);
    }

    @PutMapping
    public Client update(@RequestBody Client client)
    {
        return clientService.update(client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        clientService.delete(id);
    }
}