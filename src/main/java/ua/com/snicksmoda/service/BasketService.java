package ua.com.snicksmoda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.snicksmoda.entity.Basket;
import ua.com.snicksmoda.entity.Client;
import ua.com.snicksmoda.entity.Stuff;
import ua.com.snicksmoda.repository.BasketRepository;

@Service
public class BasketService {

    @Autowired
    ClientService clientService;

    @Autowired
    BasketRepository basketRepository;

    @Transactional
    public Long addBasket() {
        return basketRepository.save(new Basket()).getIdBasket();
    }

    @Transactional
    public boolean addStuffToBasket(Stuff stuff) {
        Basket basket = clientService.findByEmail(getEmailCurrentClient()).getBasket();
        basket.setStuff(stuff);
        return true;
    }

    private String getEmailCurrentClient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @Transactional
    public Basket getBasketById(Long idBasket) {
        return basketRepository.getOne(idBasket);
    }

    @Transactional
    public String countOfStuffInBasket(String emailCurrentClient) {
        if (emailCurrentClient == null) {
            return "";
        }

        Client client = clientService.findByEmail(emailCurrentClient);
        if (client == null) {
            return "";
        }
        if (client.getBasket().getStuffList() == null) {
            return "";
        }
        return String.valueOf(getCountOfAllStuff(client.getBasket()));
    }

    @Transactional
    public int getCountOfAllStuff(Basket basket) {
        return basket.getStuffList().size();
    }
}
