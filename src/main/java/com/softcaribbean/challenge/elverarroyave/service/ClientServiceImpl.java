package com.softcaribbean.challenge.elverarroyave.service;

import com.softcaribbean.challenge.elverarroyave.configuration.exeption.BadRequestException;
import com.softcaribbean.challenge.elverarroyave.model.Client;
import com.softcaribbean.challenge.elverarroyave.repository.ClientRepository;
import com.softcaribbean.challenge.elverarroyave.service.model.ClientSaveCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    private BSTImpl bst;

    public ClientServiceImpl(){
    }

    @PostConstruct
    public void initTree(){
        bst = new BSTImpl();
        List<Client> clients = clientRepository.findAll();
        clients.forEach(client -> {
            TreeNode newNode = new TreeNode(client);
            bst.insert(newNode);
        } );
    }

    @Override
    public Client save(ClientSaveCmd clientSaveResponse) {
        Client clientToSaveCmd = ClientSaveCmd.toModel(clientSaveResponse);
        bst.insert(new TreeNode(clientToSaveCmd)); //add client to tree
        return clientRepository.save(ClientSaveCmd.toModel(clientSaveResponse));
    }

    @Override
    public Client findByDocument(long numDocument) {
        return bst.get(numDocument);
    }

    @Override
    public void deleteByNumDocument(long numDocument) {
        Client clientToDelete = findByDocument(numDocument);
        clientRepository.deleteClientByDocument(clientToDelete.getNumDocument());
        initTree();
    }

    @Override
    public Client update(long numDocument, ClientSaveCmd clientToUpdateCmd) {
        Client clientInDataBase = findByDocument(numDocument);

        Client clientToUpdate = clientInDataBase.toBuilder()
                .firstName(clientToUpdateCmd.getFirstName())
                .lastName(clientToUpdateCmd.getLastName())
                .email(clientToUpdateCmd.getEmail())
                .gender(clientToUpdateCmd.getGender())
                .build();
        return clientRepository.save(clientToUpdate);
    }

}
