package com.softcaribbean.challenge.elverarroyave.service;

import com.softcaribbean.challenge.elverarroyave.configuration.exeption.BadRequestException;
import com.softcaribbean.challenge.elverarroyave.model.Client;
import com.softcaribbean.challenge.elverarroyave.repository.ClientRepository;
import com.softcaribbean.challenge.elverarroyave.service.mode.ClientSaveCmd;
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
        clients.forEach(bst::insert);
    }

    @Override
    public Client save(ClientSaveCmd clientSaveResponse) {
        bst.insert(ClientSaveCmd.toModel(clientSaveResponse)); //add client to tree
        return clientRepository.save(ClientSaveCmd.toModel(clientSaveResponse));
    }

    @Override
    public Client findByDocument(long numDocument) {
        return bst.get(numDocument);
    }

    @Override
    public List<Client> findAll(int order) {
        switch (order){
            case 1: return bst.preorder();
            case 2: return bst.inorder();
            case 3: return bst.postorder();
        }
        throw new BadRequestException("Order type not found.");
    }
}
