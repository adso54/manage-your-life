package eu.kamildanielski.manageyourlife.services;

import eu.kamildanielski.manageyourlife.domain.Expenditure;
import eu.kamildanielski.manageyourlife.repositories.ExpenditureRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExpenditureServiceImpl implements ExpenditureService {

    private ExpenditureRepository expenditureRepository;

    public ExpenditureServiceImpl(ExpenditureRepository expenditureRepository) {
        this.expenditureRepository = expenditureRepository;
    }

    @Override
    public Set<Expenditure> getExpenditures() {

        Set<Expenditure> expendituresSet = new HashSet<>();

        expenditureRepository.findAll().iterator().forEachRemaining(expendituresSet::add);
        return expendituresSet;
    }
}
