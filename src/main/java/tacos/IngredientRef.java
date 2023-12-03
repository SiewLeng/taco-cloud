package tacos;

import lombok.Data;

@Data
public class IngredientRef {
	
	private final String ingredient;
	
	public IngredientRef(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getIngredient() {
		return ingredient;
	}
	
}
