package tacos.data;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.sql.Types;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.stereotype.Repository;
import  org.springframework.jdbc.core.PreparedStatementCreator;

import tacos.Ingredient;
import tacos.Taco;
import tacos.TacoOrder;

@Repository
public class JdbcOrderRepository implements OrderRepository {
	
	private JdbcOperations jdbcOperations;
	
	@Autowired
	public JdbcOrderRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	@Override
	public TacoOrder save(TacoOrder order) {
		String preparedSqlStatement = "INSERT INTO taco_order "
				+ "(id, delivery_name, delivery_Street, delivery_City, " 
				+ "delivery_State, delivery_Zip, cc_number, "
				+ "cc_expiration, cc_cvv, placed_at) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
				preparedSqlStatement,
				Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
				);
		
		order.setPlacedAt(new Date());
		order.setId(new Random().nextLong());
		List<?> params = Arrays.asList(
				order.getId(),
				order.getDeliveryName(),
				order.getDeliveryStreet(),
				order.getDeliveryCity(),
				
				order.getDeliveryState(),
				order.getDeliveryZip(),
				order.getCcNumber(),
				
				order.getCcExpiry(),
				order.getCcNumber(),
				order.getPlacedAt()
				);
		PreparedStatementCreator psc = pscf.newPreparedStatementCreator(params);
		jdbcOperations.update(psc);
		
		Long i = (long) 0;
		List<Taco> tacos = order.getTacos();
		for (Taco taco: tacos) {
			this.saveTaco(taco, order.getId(), i++);
			
			Long k = (long) 0;
			List<Ingredient> ingredients = taco.getIngredients();
			for (Ingredient ingredient: ingredients) {
				this.saveTacoIngredient(ingredient, taco.getId(), k++);
			}
		}
		
		return order;
	}
	
	public Taco saveTaco(Taco taco, Long taco_order, Long taco_order_key) {
		String preparedSqlStatement = "INSERT INTO taco "
				+ "(id, name, taco_order, " 
				+ "taco_order_key, created_at) "
				+ "values (?, ?, ?, "
				+ "?, ?)";
		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
				preparedSqlStatement,
				Types.BIGINT, Types.VARCHAR, Types.BIGINT, 
				Types.BIGINT, Types.TIMESTAMP
				);

		taco.setId(new Random().nextLong());
		List<?> params = Arrays.asList(
				taco.getId(),
				taco.getName(),
				taco_order,
				
				taco_order_key,
				taco.getCreatedAt()
				);
		PreparedStatementCreator psc = pscf.newPreparedStatementCreator(params);
		jdbcOperations.update(psc);
		
		return taco;
	}
	
	public Ingredient saveTacoIngredient(Ingredient ingredient, Long taco, Long taco_key) {
		String preparedSqlStatement = "INSERT INTO taco_ingredient "
				+ "(id, ingredient, taco, taco_key) "
				+ "values (?, ?, ?, ?)";
		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
				preparedSqlStatement,
				Types.BIGINT, Types.VARCHAR, Types.BIGINT, Types.BIGINT
				);

		List<?> params = Arrays.asList(
				new Random().nextLong(),
				ingredient.getId(),
				taco,
				taco_key
				);
		PreparedStatementCreator psc = pscf.newPreparedStatementCreator(params);
		jdbcOperations.update(psc);
		return ingredient;
		
	}
	
}
