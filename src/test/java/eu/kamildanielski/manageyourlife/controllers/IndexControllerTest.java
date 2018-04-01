package eu.kamildanielski.manageyourlife.controllers;

import eu.kamildanielski.manageyourlife.domain.Expenditure;
import eu.kamildanielski.manageyourlife.services.ExpenditureService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

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
        //given
        Set<Expenditure> expenditures = new HashSet<>();
        Expenditure ex1 = new Expenditure();
        ex1.setId(1L);
        Expenditure ex2 = new Expenditure();
        ex2.setId(2L);
        expenditures.add((ex1));
        expenditures.add((ex2));

        ArgumentCaptor<Set<Expenditure>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        when(expenditureService.getExpenditures()).thenReturn(expenditures);

        //when
        String viewName = controller.getIndexPage(model);

        //then
        assertEquals("index", viewName);
        verify(expenditureService, times(1)).getExpenditures();
        verify(model, times(1)).addAttribute(eq("expenditures"), argumentCaptor.capture());
        Set<Expenditure> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}