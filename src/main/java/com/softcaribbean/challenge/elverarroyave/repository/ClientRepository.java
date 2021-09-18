package com.softcaribbean.challenge.elverarroyave.repository;

import com.softcaribbean.challenge.elverarroyave.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
