package com.softcaribbean.challenge.elverarroyave.controller;

import com.softcaribbean.challenge.elverarroyave.controller.model.ClientSaveRequest;
import com.softcaribbean.challenge.elverarroyave.controller.model.ClientSaveResponse;
import com.softcaribbean.challenge.elverarroyave.model.Client;
import com.softcaribbean.challenge.elverarroyave.service.ClientService;
import com.softcaribbean.challenge.elverarroyave.service.mode.ClientSaveCmd;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@RestController
@RequestMapping("/api/v1/clients")
@Api(tags = "SoftCaribbean", value="SoftCaribbean")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid ClientSaveRequest clientToCreate){
        ClientSaveCmd clientSaveCmd = ClientSaveRequest.toModel(clientToCreate);
        Client clientCreated = clientService.save(clientSaveCmd);

        URI location = fromUriString("/api/v1/clients").path("/{id}")
                .buildAndExpand(clientCreated.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{document}")
    public ResponseEntity<ClientSaveResponse> findByDocument(@Valid @PathVariable("document") @NotNull long document){

        Client clientFound = clientService.findByDocument(document);

        return ResponseEntity.ok(ClientSaveResponse.fromModel(clientFound));
    }

}
