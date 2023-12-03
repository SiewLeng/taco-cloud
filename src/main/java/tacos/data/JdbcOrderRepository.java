package tacos.data;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.sql.Types;

import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.stereotype.Repository;
import  org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

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
				Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
				);
		
		pscf.setReturnGeneratedKeys(false);
		
		order.setId(new Random().nextInt());
		order.setPlacedAt(new Date());
		
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
		
		return order;
	}
}
