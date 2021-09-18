package com.softcaribbean.challenge.elverarroyave.service.mode;

import com.softcaribbean.challenge.elverarroyave.model.Client;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientSaveCmd {
    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    public static Client toModel(ClientSaveCmd clientToSaveCmd){
        return  Client.builder()
                .firstName(clientToSaveCmd.firstName)
                .lastName(clientToSaveCmd.lastName)
                .email(clientToSaveCmd.email)
                .gender(clientToSaveCmd.gender)
                .build();
    }
}
