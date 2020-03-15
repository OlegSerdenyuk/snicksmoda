package ua.com.snicksmoda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.snicksmoda.entity.Client;
import ua.com.snicksmoda.entity.Role;

import java.util.Arrays;
import java.util.List;

@Service
public class ClientDetailsService implements UserDetailsService {

    @Autowired
    private ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientService.findByEmail(email);
        String emailGet = client.getEmail();
        String password = client.getPassword().toString();
        String role = client.getRole().toString();

        List<GrantedAuthority> roleGet = Arrays.asList(new SimpleGrantedAuthority(client.getRole().toString()));
        return new User(client.getEmail(), client.getPassword(), roleGet);
    }
}
