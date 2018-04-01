package eu.kamildanielski.manageyourlife.services;

import eu.kamildanielski.manageyourlife.domain.User;
import eu.kamildanielski.manageyourlife.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void getUsers() {

        User user = new User();
        HashSet usersData = new HashSet();
        usersData.add(user);

        when(userService.getUsers()).thenReturn(usersData);

        Set<User> users = userService.getUsers();

        assertEquals(users.size(), 1);

        verify(userRepository, times(1)).findAll();

    }
}