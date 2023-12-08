package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import tacos.entities.Ingredient;
import tacos.entities.Ingredient.Type;
import tacos.respository.IngredientRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
/*
@EntityScan({"tacos."})
@EnableJpaRepositories("tacos.")
@ComponentScan(basePackages = { "tacos." })
*/
public class TacoCloudApplication implements CommandLineRunner  {
	
	@Autowired
	IngredientRespository repo;

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}
	
	@Override 
	public void run(String... args) throws Exception {
		repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
		repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
		repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
		repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
		repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
		repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
		repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
		repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
		repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
		repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
	}
	

}
