package ua.com.snicksmoda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.snicksmoda.entity.Category;
import ua.com.snicksmoda.entity.Client;
import ua.com.snicksmoda.entity.Role;
import ua.com.snicksmoda.entity.Stuff;
import ua.com.snicksmoda.repository.StuffRepository;

@Service
public class StuffService {

    @Autowired
    StuffRepository stuffRepository;

    @Secured("ROLE_ADMIN")
    @Transactional
    public boolean addStuff(String name, Category category, String description, Long price, String urlPhoto) {
        Stuff stuff = new Stuff(name, category, description, price, urlPhoto);
        stuffRepository.save(stuff);
        return true;
    }

    @Secured("ROLE_ADMIN")
    @Transactional
    public boolean saveStuff(Stuff stuff) {
        if (stuffRepository.existsById(stuff.getIdStuff())) {
            return false;
        }
        stuffRepository.save(stuff);
        return true;
    }

    @Transactional
    public Stuff findByName(String name) {
        return stuffRepository.findByName(name);
    }
}
