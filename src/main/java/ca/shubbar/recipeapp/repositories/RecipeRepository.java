package ca.shubbar.recipeapp.repositories;

import ca.shubbar.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-25
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
