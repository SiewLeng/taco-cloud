package tacos.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacos.entities.Ingredient;

@Repository
public interface IngredientRespository extends CrudRepository<Ingredient, String> {

}
