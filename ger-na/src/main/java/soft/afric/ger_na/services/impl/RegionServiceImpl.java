package soft.afric.ger_na.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.repositories.IRegionRepository;
import soft.afric.ger_na.services.RegionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
    private final IRegionRepository repository;
    @Override
    public List<Region> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Region> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Region findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
