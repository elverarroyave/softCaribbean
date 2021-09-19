package com.softcaribbean.challenge.elverarroyave.service;

import com.softcaribbean.challenge.elverarroyave.model.Client;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl implements BST<Client> {

    private Client valor;

    private BSTImpl left, right;

    private int amount;

    @Override
    public void insert(Client client) {
        if(valor == null){
            this.valor = client;
            amount++;
        }else{
            if(client.compareTo(valor) < 0){
                if(left == null) left = new BSTImpl();
                left.insert(client);
                amount++;
            }else if (client.compareTo(valor) > 0){
                if(right == null) right = new BSTImpl();
                right.insert(client);
                amount++;
            } else {
                // Throw new
            }
        }
    }

    @Override
    public boolean exist(long numDocument) {
        if(valor!=null){
            if(valor.getNumDocument() == numDocument){
                return true;
            }else if(valor.getNumDocument() < numDocument && right != null){
                return right.exist(numDocument);
            } else if(valor.getNumDocument() > numDocument && left != null){
                return left.exist(numDocument);
            } else {
                //Throw new
                return false;
            }
        }else{
            //Throw new
            return false;
        }
    }

    @Override
    public Client get(long numDocument) {
        System.out.println("Salto");
        if(valor !=null){
            if(valor.getNumDocument() == numDocument){
                return valor;
            }else if(valor.getNumDocument()<numDocument && right != null){
                return right.get(numDocument);
            }else if(valor.getNumDocument()>numDocument && left != null){
                return  left.get(numDocument);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    private List<Client> clients = new ArrayList<>();

    @Override
    public List<Client> preorder() {
        if (valor != null){
             clients.add(valor);
             if(left != null) left.preorder();
             if(right != null) right.preorder();
        }
        return clients;
    }

    @Override
    public List<Client> inorder() {
        if (valor != null){
            if(left != null) left.inorder();
            clients.add(valor);
            if(right != null) right.inorder();
        }
        return clients;
    }

    @Override
    public List<Client> postorder() {
        if(valor != null){
            if(left != null) left.postorder();
            if(right != null) right.postorder();
            clients.add(valor);
        }
        return clients;
    }

    public int getAmount() {
        return amount;
    }
}
