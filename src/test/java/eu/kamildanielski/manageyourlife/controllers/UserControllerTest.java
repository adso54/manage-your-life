package eu.kamildanielski.manageyourlife.controllers;

import eu.kamildanielski.manageyourlife.domain.User;
import eu.kamildanielski.manageyourlife.repositories.UserRepository;
import eu.kamildanielski.manageyourlife.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class UserControllerTest {

    @Mock
    UserService userService;

    UserController userController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        userController =new UserController(userService);

    }

    @Test
    public void testGetUser() throws Exception {

        User user = new User();
        user.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        when(userService.getUserById(anyLong())).thenReturn(user);

        mockMvc.perform(get("/user/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/show"));
    }
}