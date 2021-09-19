package com.softcaribbean.challenge.elverarroyave.service;

import com.softcaribbean.challenge.elverarroyave.configuration.exeption.BadRequestException;
import com.softcaribbean.challenge.elverarroyave.model.Client;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl implements BST{

    private TreeNode root;

    private int amount;

    public BSTImpl(){
        root = null;
    }

    @Override
    public void insert(TreeNode newNode) {
        if(root == null){
            this.root = newNode;
            amount++;
        }else{
            TreeNode aux = root;
            TreeNode dad;
            while(true){
                dad = aux;
                if(newNode.getClient().getNumDocument() < aux.getClient().getNumDocument()){
                    aux=aux.getLeftNode();
                    if(aux==null){
                        dad.setLeftNode(newNode);
                        amount++;
                        return;
                    }
                } else{
                    aux=aux.getRightNode();
                    if(aux==null){
                        dad.setRightNode(newNode);
                        amount++;
                        return;
                    }
                }
            }
        }
    }

    @Override
    public Client get(long numDocument) {
        int jump = 0;
        TreeNode aux = root;
        while(aux.getClient().getNumDocument() != numDocument){
            if(numDocument<aux.getClient().getNumDocument()) {
                aux = aux.getLeftNode();
            }else{
                aux = aux.getRightNode();
            } if(aux==null){
                throw new BadRequestException("Client with number document: " +  numDocument + " not found. Check number document please.");
            }
            jump++;
        }
        System.out.println("Jumps:" + jump);
        return aux.getClient();
    }

}
