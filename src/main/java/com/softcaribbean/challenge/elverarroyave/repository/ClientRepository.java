package com.softcaribbean.challenge.elverarroyave.repository;

import com.softcaribbean.challenge.elverarroyave.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM CLIENT c WHERE c.numDocument = ?1")
    void deleteClientByDocument(@NotNull long numDocument);
}
