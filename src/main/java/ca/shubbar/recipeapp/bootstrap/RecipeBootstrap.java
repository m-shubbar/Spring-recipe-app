package ca.shubbar.recipeapp.bootstrap;

import ca.shubbar.recipeapp.domain.*;
import ca.shubbar.recipeapp.repositories.CategoryRepository;
import ca.shubbar.recipeapp.repositories.RecipeRepository;
import ca.shubbar.recipeapp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-25
 */

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {



    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
                           UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }



    @Override
    // by doing this transactional annotation to create a transaction around this method
    // This will prevent the "lazy initialization" exception
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipe());

        log.debug("Loading bootstrap data... - mustafa - ");
    }




    private List<Recipe> getRecipe(){

        List<Recipe> recipes = new ArrayList<>(2);

        // get UOMs
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if(!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found.");
        }

        Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tablespoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found.");
        }

        Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if(!teaspoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found.");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if(!dashUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found.");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if(!pintUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found.");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(!cupUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found.");
        }

        // Get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tablespoonUom = tablespoonUomOptional.get();
        UnitOfMeasure teaspoonUom = teaspoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();

        // get categories
        Optional<Category> americanCategoryOption = categoryRepository.findByDescription("American");

        if(!americanCategoryOption.isPresent()) {
            throw new RuntimeException("Expected category not found.");
        }

        Optional<Category> mexicanCategoryOption = categoryRepository.findByDescription("Mexican");

        if(!mexicanCategoryOption.isPresent()) {
            throw new RuntimeException("Expected category not found.");
        }

        Category americanCategory = americanCategoryOption.get();
        Category mexicanCategory = mexicanCategoryOption.get();

        // Recipe time
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("Just another recipe LONG description (directions)");

        Notes guaNotes = new Notes();
        guaNotes.setRecipeNotes("Just another recipe note");


        guacRecipe.setNotes(guaNotes);

        guacRecipe.getIngredients().add(new Ingredient("ripe avocado", new BigDecimal(2), eachUom));
        guacRecipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(5), teaspoonUom));
        guacRecipe.getIngredients().add(new Ingredient("Lime", new BigDecimal(2), tablespoonUom));
        guacRecipe.getIngredients().add(new Ingredient("Red onion", new BigDecimal(2), tablespoonUom));
        guacRecipe.getIngredients().add(new Ingredient("Serrano chilies", new BigDecimal(1), eachUom));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        recipes.add(guacRecipe);


        return recipes;
    }
}
