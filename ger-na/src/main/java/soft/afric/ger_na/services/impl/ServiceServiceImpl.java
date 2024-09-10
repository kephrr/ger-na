package soft.afric.ger_na.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import soft.afric.ger_na.data.entities.Service;
import soft.afric.ger_na.data.repositories.IServiceRepository;
import soft.afric.ger_na.services.ServiceService;

import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    private final IServiceRepository repository;
    @Override
    public List<Service> findAll() {
        return repository.findAllByIsActiveTrue();
    }

    @Override
    public Optional<Service> show(Long dataID) {
        return repository.findByIdAndIsActiveTrue(dataID);
    }

    @Override
    public Service save(Service data) {
        return repository.save(data);
    }

    @Override
    public Page<Service> findAll(Pageable page) {
        return repository.findAllByIsActiveTrue(page);
    }

}
