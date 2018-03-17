package eu.kamildanielski.manageyourlife.services;

import eu.kamildanielski.manageyourlife.domain.User;

import java.util.Set;

public interface UserService {

    Set<User> getUsers();
}
