package tacos.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Ingredient {
	
	@Id
	private final String id;
	
	private final String name;
	
	private final Type type;
	
	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
	
	public Ingredient() {
		this.id = null;
		this.name = null;
		this.type = null;
	}

	public Ingredient(String id, String name, Type type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	
}
