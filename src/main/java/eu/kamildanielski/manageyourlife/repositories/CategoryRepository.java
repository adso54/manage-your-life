package eu.kamildanielski.manageyourlife.repositories;

import eu.kamildanielski.manageyourlife.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByName(String name);

}
