package com.arnold.sabackend.repositories;

import com.arnold.sabackend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findByEmail(String email);
}
