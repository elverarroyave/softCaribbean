package com.softcaribbean.challenge.elverarroyave.service;

public interface BST<T extends Comparable>{

    void insert(T client);

    boolean exist(int id);

    T get(int id);
}
