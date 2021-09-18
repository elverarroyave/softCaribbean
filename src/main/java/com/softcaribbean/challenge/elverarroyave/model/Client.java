package com.softcaribbean.challenge.elverarroyave.model;

import lombok.Builder;

import javax.persistence.*;

@Builder(toBuilder = true)
@Entity(name = "Client")
@Table(name="CLIENT")
public class Client implements Comparable<Client>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirsName() {
        return firstName;
    }

    public void setFirsName(String firsName) {
        this.firstName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String fullName(){
        return firstName + " " + lastName;
    }

    public Client(){}

    public Client(Long id, String firsName, String lastName, String email, String gender) {
        this.id = id;
        this.firstName = firsName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public int compareTo(Client client) {
        if (id == client.id){
            return 0;
        }else if(id < client.id){
            return -1;
        }else {
            return 1;
        }
    }
}
