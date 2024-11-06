package dev.kaan.Instrument.Service.client;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {


    Optional<Client> findByClientNo(Long requestedNo);
}
