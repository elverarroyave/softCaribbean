package com.softcaribbean.challenge.elverarroyave.controller.model;

import com.softcaribbean.challenge.elverarroyave.service.mode.ClientSaveCmd;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ClientSaveRequest {

    private long numDocument;

    private String firstName;

    private String lastName;

    private String email;

    private String gender;


    public static ClientSaveCmd toModel(ClientSaveRequest clientToSaveRequest){
        return ClientSaveCmd.builder()
                .firstName(clientToSaveRequest.getFirstName())
                .lastName(clientToSaveRequest.getLastName())
                .numDocument(clientToSaveRequest.getNumDocument())
                .email(clientToSaveRequest.getEmail())
                .gender(clientToSaveRequest.getGender())
                .build();
    }



}
