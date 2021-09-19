package com.softcaribbean.challenge.elverarroyave.service;

import com.softcaribbean.challenge.elverarroyave.model.Client;

import java.util.List;

public interface BST<T extends Comparable>{

    void insert(T client);

    boolean exist(long numDocument);

    T get(long numDocument);

    List<Client> preorder();

    List<Client> inorder();

    List<Client> postorder();

}
