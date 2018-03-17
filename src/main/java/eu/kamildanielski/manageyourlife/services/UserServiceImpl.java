package eu.kamildanielski.manageyourlife.services;

import eu.kamildanielski.manageyourlife.domain.User;
import org.springframework.stereotype.Service;
import eu.kamildanielski.manageyourlife.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> getUsers() {

        Set<User> userSet = new HashSet<>();

        userRepository.findAll().iterator().forEachRemaining(userSet::add);

        return userSet;
    }
}
