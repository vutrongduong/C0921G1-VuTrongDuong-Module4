package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.codegym.model.MyUserDetail;
import vn.codegym.model.User;
import vn.codegym.repository.IUserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private IUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User name: " + username + " not found. ");
        }

        return new MyUserDetail(user);
    }
}
