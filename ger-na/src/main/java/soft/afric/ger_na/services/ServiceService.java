package soft.afric.ger_na.services;

import soft.afric.ger_na.data.entities.Service;


import java.util.List;

public interface ServiceService {
    List<Service> findAll();
    Service findById(Long id);

}
