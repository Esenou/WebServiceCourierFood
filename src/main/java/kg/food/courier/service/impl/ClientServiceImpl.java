package kg.food.courier.service.impl;


import kg.food.courier.entity.Client;
import kg.food.courier.repository.ClientRepository;
import kg.food.courier.service.ClientService;
import kg.food.courier.service.base.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends BaseServiceImpl<Client, ClientRepository> implements ClientService {

    private final ClientRepository clientRepository;
    public ClientServiceImpl(ClientRepository clientRepository) {
        super(clientRepository);
        this.clientRepository = clientRepository;
    }

    @Override
    public Page<Client> findByUsernameWithSearch(Pageable pageable, String value) {
        return clientRepository.findByUsernameWithSearch(pageable,value);
    }

    @Override
    public Page<Client> getAllByPageable(Pageable pageable) {
        return clientRepository.getAllByPageable(pageable);
    }



}
