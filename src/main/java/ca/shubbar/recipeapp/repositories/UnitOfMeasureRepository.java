package ca.shubbar.recipeapp.repositories;

import ca.shubbar.recipeapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-25
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
