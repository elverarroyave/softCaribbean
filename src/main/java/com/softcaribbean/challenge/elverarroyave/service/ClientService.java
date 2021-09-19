package com.softcaribbean.challenge.elverarroyave.service;

import com.softcaribbean.challenge.elverarroyave.model.Client;
import com.softcaribbean.challenge.elverarroyave.service.model.ClientSaveCmd;
import com.sun.istack.NotNull;

import java.util.List;

public interface ClientService {

    Client save(@NotNull ClientSaveCmd clientSaveResponse);

    Client findByDocument(@NotNull long numDocument);

    void deleteByNumDocument(@NotNull long numDocument);

    Client update(@NotNull long numDocument, @NotNull ClientSaveCmd clientSaveResponse);
}
