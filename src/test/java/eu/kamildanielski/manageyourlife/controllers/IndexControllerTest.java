package eu.kamildanielski.manageyourlife.controllers;

import eu.kamildanielski.manageyourlife.services.ExpenditureService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class IndexControllerTest {

    @Mock
    ExpenditureService expenditureService;

    @Mock
    Model model;

    IndexController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new IndexController(expenditureService);
    }

    @Test
    public void getIndexPage() {

        String viewName = controller.getIndexPage(model);

        assertEquals("index", viewName);
        verify(expenditureService, times(1)).getExpenditures();
        verify(model, times(1)).addAttribute(eq("expenditures"), anySet());

    }
}