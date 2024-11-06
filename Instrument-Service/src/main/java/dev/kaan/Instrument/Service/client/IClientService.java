package dev.kaan.Instrument.Service.client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    Optional<Client> findByClientNo(Long requestedNo);

     List<Optional> findByRole(Role requeestedRole);

    Optional<Client> findByClientId(Long requestedId);

    Client createAClient(Client clientToCreate);
}