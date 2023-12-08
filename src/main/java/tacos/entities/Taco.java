package tacos.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Taco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@ManyToMany()
	private List<Ingredient> ingredients;
	
	private final Date createdAt = new Date();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
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
	
	public Date getCreatedAt() {
		return createdAt;
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
