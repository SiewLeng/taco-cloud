package tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.Ingredient;
import tacos.data.JdbcIngredientRepository;


@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
	
	private JdbcIngredientRepository jdbcIngredientRepository;
	
	@Autowired
	public IngredientByIdConverter(JdbcIngredientRepository jdbcIngredientRepository) {
		this.jdbcIngredientRepository = jdbcIngredientRepository;
	}
	
	 @Override
	 public Ingredient convert(String id) {
		 return this.jdbcIngredientRepository.findById(id).orElse(null);
	 }

}
