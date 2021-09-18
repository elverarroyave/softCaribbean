package com.softcaribbean.challenge.elverarroyave.service;

import com.softcaribbean.challenge.elverarroyave.model.Client;

public class BSTImpl implements BST<Client> {

    private Client valor;

    private BSTImpl left, right;

    private int amount;

    private int jump = 0;

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
    public boolean exist(int id) {
        if(valor!=null){
            if(valor.getId() == id){
                return true;
            }else if(valor.getId() < id && right != null){
                return right.exist(id);
            } else if(valor.getId() > id && left != null){
                return left.exist(id);
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
    public Client get(int id) {
        System.out.println("Jump number: " + jump++);
        if(valor !=null){
            if(valor.getId() == id){
                return valor;
            }else if(valor.getId()<id && right != null){
                return right.get(id);
            }else if(valor.getId()>id && left != null){
                return  left.get(id);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public int getAmount() {
        return amount;
    }
}
