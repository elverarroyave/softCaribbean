package com.softcaribbean.challenge.elverarroyave.service;

import com.softcaribbean.challenge.elverarroyave.model.Client;
import com.softcaribbean.challenge.elverarroyave.repository.ClientRepository;
import com.softcaribbean.challenge.elverarroyave.service.mode.ClientSaveCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client save(ClientSaveCmd clientSaveResponse) {
        return clientRepository.save(ClientSaveCmd.toModel(clientSaveResponse));
    }
}
