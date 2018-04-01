package eu.kamildanielski.manageyourlife.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    public void getId() {
        Long id = 4L;

        user.setId(id);
        assertEquals(id, user.getId());
    }


    @Test
    public void getFirstName() {
        String firstName = "Kamil";

        user.setFirstName(firstName);
        assertEquals(firstName, user.getFirstName());
    }

    @Test
    public void getLastName() {
        String lastName = "Danielski";

        user.setLastName(lastName);
        assertEquals(lastName, user.getLastName());
    }
}