package com.softcaribbean.challenge.elverarroyave.controller.model;

import com.softcaribbean.challenge.elverarroyave.model.Client;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ClientSaveResponse {

    private long numDocument;

    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    public static ClientSaveResponse fromModel(Client clientToResponse){
        return ClientSaveResponse.builder()
                .numDocument(clientToResponse.getNumDocument())
                .firstName(clientToResponse.getFirsName())
                .lastName(clientToResponse.getLastName())
                .email(clientToResponse.getEmail())
                .gender(clientToResponse.getGender())
                .build();
    }
}
