package tacos.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tacos.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {
	
	private JdbcTemplate jdbcTemplate;
    
	@Autowired
	public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Iterable<Ingredient> findAll() {
		String query = "SELECT id, name, type FROM ingredient";
		return this.jdbcTemplate.query(query, new IngredientMapper());
		
	}
	
	@Override
	public Optional<Ingredient> findById(String id){
		String query = "SELECT id, name, type FROM ingredient where id=?";
		List<Ingredient> result = this.jdbcTemplate.query(query, new IngredientMapper(), id);
		return result.size() == 0 ? Optional.empty() : Optional.of(result.get(0));
	};
	
	@Override
	public Ingredient save(Ingredient ingredient) {
		String updateStatement = "INSERT INTO ingredient (id, name, type) Values (?. ?, ?)";
		this.jdbcTemplate.update(
				updateStatement,
				ingredient.getId(),
				ingredient.getName(),
				ingredient.getType()
				);
		return ingredient;
	}

}
