package ua.com.snicksmoda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.snicksmoda.entity.Client;
import ua.com.snicksmoda.entity.Role;
import ua.com.snicksmoda.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    private BasketService basketService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailService mailService;

//    @Transactional
//    public boolean addClient(String name, String surname, String email, String phone, Role role) {
//        Client client = new Client(name, surname, email, phone, role);
//        clientRepository.save(client);
//        return true;
//    }

    @Transactional
    public boolean saveClient(Client client) {
        if (clientRepository.existsById(client.getIdClient())) {
            return false;
        }
        Long basket = basketService.addBasket();
        client.setBasket(basketService.getBasketById(basket));
        clientRepository.save(client);
        return true;
    }

    @Transactional
    public void updateClient(String name, String surname, String email, String phone) {
        Client client = clientRepository.findByEmail(email);
        if (client == null) {
            return;
        }
        client.setName(name);
        client.setSurName(surname);
        client.setEmail(email);
        client.setPhone(phone);
        clientRepository.save(client);
    }

    @Transactional
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public List<Client> getAllClient(Client client) {
        return (List<Client>) clientRepository.getAllClient(client);
    }

    @Transactional
    public Client getEmail(String email) {
        return clientRepository.getEmail(email);
    }

    public boolean changePassword(Client client, String password) {
        if (client == null) {
            return false;
        }
        client.setPassword(passwordEncoder.encode(password));
        clientRepository.save(client);
        return true;
    }
}
