package com.softcaribbean.challenge.elverarroyave.service;

import com.softcaribbean.challenge.elverarroyave.model.Client;
import com.softcaribbean.challenge.elverarroyave.service.mode.ClientSaveCmd;
import com.sun.istack.NotNull;

import java.util.List;

public interface ClientService {

    Client save(@NotNull ClientSaveCmd clientSaveResponse);

    Client findByDocument(@NotNull long numDocument);

    List<Client> findAll(int order);
}
