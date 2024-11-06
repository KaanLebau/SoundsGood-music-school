package dev.kaan.Instrument.Service.client;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClientService implements IClientService{
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Client> findByClientNo(Long requestedNo) { return repository.findByClientNo(requestedNo); }


    @Override
    public Optional<Client> findByClientId(Long requestedId) {
        return repository.findById(requestedId);
    }

    @Override
    public List<Optional> findByRole(Role requeestedRole) {
        return null;
    }

    @Override
    public Client createAClient(Client clientToCreate) {
        return repository.save(clientToCreate);
    }
}
