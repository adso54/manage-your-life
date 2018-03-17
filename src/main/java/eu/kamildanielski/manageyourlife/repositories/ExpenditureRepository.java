package eu.kamildanielski.manageyourlife.repositories;

import eu.kamildanielski.manageyourlife.domain.Expenditure;
import org.springframework.data.repository.CrudRepository;

public interface ExpenditureRepository extends CrudRepository<Expenditure, Long> {


}
