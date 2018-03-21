package eu.kamildanielski.manageyourlife.services;

import eu.kamildanielski.manageyourlife.domain.Expenditure;

import java.util.Set;


public interface ExpenditureService {

    Set<Expenditure> getExpenditures();
}
