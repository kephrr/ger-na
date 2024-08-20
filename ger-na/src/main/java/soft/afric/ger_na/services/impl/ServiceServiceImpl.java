package soft.afric.ger_na.services.impl;

import lombok.RequiredArgsConstructor;
import soft.afric.ger_na.data.entities.Service;
import soft.afric.ger_na.data.repositories.IServiceRepository;
import soft.afric.ger_na.services.ServiceService;

import java.util.List;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    private final IServiceRepository repository;
    @Override
    public List<Service> findAll() {
        return repository.findAll();
    }

    @Override
    public Service findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
