package eu.kamildanielski.manageyourlife.services;

import eu.kamildanielski.manageyourlife.domain.User;
import org.springframework.stereotype.Service;
import eu.kamildanielski.manageyourlife.repositories.UserRepository;

import java.util.HashSet;
import java.util.Optional;
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

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent())
            throw new RuntimeException("User not found!");

        return userOptional.get();
    }
}
