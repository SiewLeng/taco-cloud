package tacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Taco {
	
	private String name;
	private List<Ingredient> ingredients;
	private Long id;
	private Date createdAt = new Date();
	
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
