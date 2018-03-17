package eu.kamildanielski.manageyourlife.repositories;

import eu.kamildanielski.manageyourlife.domain.SubCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SubCategoryRepository extends CrudRepository<SubCategory, Long>{

    Optional<SubCategory> findByName (String name);
}
