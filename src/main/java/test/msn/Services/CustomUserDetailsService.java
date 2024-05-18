package test.msn.Services;

import test.msn.Dao.DaoUsers1;
import test.msn.Entities.Users1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;


@Service(value = "CustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    DaoUsers1 daoUsers1;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users1 u = daoUsers1.byEmail(username);

        return User.withUsername(u.getUsername())
                .password(u.getPassword())
                .authorities("USER")
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
