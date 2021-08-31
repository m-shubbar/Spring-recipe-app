package ca.shubbar.recipeapp.services;

import ca.shubbar.recipeapp.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-25
 */

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long l);
}
