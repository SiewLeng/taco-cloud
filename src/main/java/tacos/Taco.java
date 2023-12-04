package tacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Taco {
	
	private Long id;
	private String name;
	private List<Ingredient> ingredients;
	private Date createdAt; 
	
	public Taco() {
		this.name = "";
		this.ingredients = new ArrayList<>();
		this.createdAt = null;
	}
	
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		String result = "\n" + "{name: " + this.name;
		result += "\n" + "ingredients: [";
		for (int i = 0; i < this.ingredients.size(); i++) {
			result += "\n" + "{name: " + this.ingredients.get(i).getName() + ", ";
			result += "type: " + this.ingredients.get(i).getType() + "}";
		}
		result += "\n" + "]";
		result += "\n" + "createdAt: " + this.createdAt.toString() + "}";
		return result;
	}
	
}
