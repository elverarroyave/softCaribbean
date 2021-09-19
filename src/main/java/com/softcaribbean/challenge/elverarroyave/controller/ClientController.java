package com.softcaribbean.challenge.elverarroyave.controller;

import com.softcaribbean.challenge.elverarroyave.configuration.MessageResponse;
import com.softcaribbean.challenge.elverarroyave.controller.model.ClientSaveRequest;
import com.softcaribbean.challenge.elverarroyave.controller.model.ClientSaveResponse;
import com.softcaribbean.challenge.elverarroyave.model.Client;
import com.softcaribbean.challenge.elverarroyave.service.ClientService;
import com.softcaribbean.challenge.elverarroyave.service.model.ClientSaveCmd;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@RestController
@RequestMapping("/api/v1/clients")
@Api(tags = "SoftCaribbean", value="SoftCaribbean")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    @ApiOperation(value = "Save client.")
    public ResponseEntity<Void> save(@RequestBody @Valid ClientSaveRequest clientToCreate){
        ClientSaveCmd clientSaveCmd = ClientSaveRequest.toModel(clientToCreate);
        Client clientCreated = clientService.save(clientSaveCmd);

        URI location = fromUriString("/api/v1/clients").path("/{id}")
                .buildAndExpand(clientCreated.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{document}")
    @ApiOperation(value = "Find client by number document.")
    public ResponseEntity<ClientSaveResponse> findByDocument(@Valid @PathVariable("document") @NotNull long document){

        Client clientFound = clientService.findByDocument(document);

        return ResponseEntity.ok(ClientSaveResponse.fromModel(clientFound));
    }

    @DeleteMapping("/{document}")
    public ResponseEntity<MessageResponse> deleteById(@Valid @PathVariable("document") @NotNull long document){
        clientService.deleteByNumDocument(document);
        return new ResponseEntity<>(new MessageResponse("Client deleted successfully"), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{document}")
    public ResponseEntity<ClientSaveResponse> update(@PathVariable("document") @NotNull long document,
                                                     @RequestBody @Valid ClientSaveRequest clientToUpdateRequest){
        ClientSaveCmd clientToUpdateCmd = ClientSaveRequest.toModel(clientToUpdateRequest);

        Client clientUpdated = clientService.update(document,clientToUpdateCmd);

        return ResponseEntity.ok(ClientSaveResponse.fromModel(clientUpdated));
    }

}
