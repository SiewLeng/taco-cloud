package tacos.web;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.data.JdbcIngredientRepository;
import tacos.Taco;
import tacos.TacoOrder;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
	
	private static final org.slf4j.Logger log =
			org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);
	
	private JdbcIngredientRepository jdbcIngredientRepository;
	
	@Autowired
	public DesignTacoController(JdbcIngredientRepository jdbcIngredientRepository) {
		this.jdbcIngredientRepository = jdbcIngredientRepository;
	}

	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = (List<Ingredient>) this.jdbcIngredientRepository.findAll();
		
		Type[] types = Ingredient.Type.values();
		for (Type type: types) {
			model.addAttribute(
					type.toString().toLowerCase(), 
					filterByType(ingredients, type)
			);
		}
		
	}
	
	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
		return ingredients
				.stream()
				.filter(x -> x.getType().equals(type))
				.collect(Collectors.toList());
	}
	
	@ModelAttribute(name="tacoOrder")
	public TacoOrder order() {
		return new TacoOrder();
	}
	
	@ModelAttribute(name="taco")
	public Taco taco() {
		return new Taco();
	}
	
	@GetMapping
	public String showDesignForm() {
		return "design";
	}
	
	@PostMapping
	public String processTaco(Taco taco, 
			@ModelAttribute TacoOrder tacoOrder) {
		taco.setCreatedAt(new Date());
		tacoOrder.addTaco(taco);
		log.info("Processing taco: {}", taco.toString());
		log.info("TacoOrder: {}", tacoOrder.toString());
		return "redirect:/orders/current";
	}
	
}
