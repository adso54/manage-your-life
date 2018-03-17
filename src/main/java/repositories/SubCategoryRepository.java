package repositories;

import domain.SubCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SubCategoryRepository extends CrudRepository<SubCategory, Long>{

    Optional<SubCategory> findByName (String name);
}
