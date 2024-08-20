package soft.afric.ger_na.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.entities.Zone;
import soft.afric.ger_na.data.repositories.IZoneRepository;
import soft.afric.ger_na.services.ZoneService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZoneServiceImpl implements ZoneService {
    private final IZoneRepository repository;
    @Override
    public List<Zone> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Zone> findAll(Region region) {
        return repository.findAllByRegion(region);
    }

    @Override
    public Zone findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
