package tacos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Taco {
	
	private String name;
	
	private List<Ingredient> ingredients;
	
	public Taco() {
		this.name = "";
		this.ingredients = new ArrayList<>();
	}

	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String result = "\n" + "{name: " + this.name;
		result += "\n" + "ingredients: [";
		for (int i = 0; i < this.ingredients.size(); i++) {
			result += "\n" + "{name: " + this.ingredients.get(i).getName() + ", ";
			result += "type: " + this.ingredients.get(i).getType() + "}";
		}
		result += "\n" + "]}";
		return result;
	}
	
}
